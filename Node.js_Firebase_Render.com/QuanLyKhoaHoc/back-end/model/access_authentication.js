// authRoutes.js
const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jwt-simple');
const admin = require('../config/firebase'); // Sử dụng Firebase Admin SDK đã được khởi tạo
const { authenticateJWT, checkRole } = require('../config/authentication');

const router = express.Router();
const db = admin.firestore();
const collection = db.collection('users');

// Route đăng ký người dùng
router.post('/signup', async (req, res) => {
  const { email, password, username, role } = req.body;

  try {
    const userRecord = await admin.auth().getUserByEmail(email);
    if (userRecord) {
      return res.status(400).json({ message: 'Email đã được sử dụng' });
    }
  } catch (error) {
    if (error.code !== 'auth/user-not-found') {
      return res.status(500).json({ message: 'Lỗi khi kiểm tra email: ' + error.message });
    }
  }

  try {
    const usernameSnapshot = await db.collection('users').where('username', '==', username).get();
    if (!usernameSnapshot.empty) {
      return res.status(400).json({ message: 'Username đã được sử dụng' });
    }

    const hashedPassword = await bcrypt.hash(password, 10);
    const userRecord = await admin.auth().createUser({
      email: email,
      password: password,  // Mật khẩu không cần mã hóa ở đây
      displayName: username,
    });

    await admin.auth().setCustomUserClaims(userRecord.uid, { role: role || 'user' });

    const userRef = db.collection('users').doc(userRecord.uid);
    await userRef.set({
      email: email,
      username: username,
      role: role || 'user',
      hashedPassword: hashedPassword,
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
    });

    res.status(201).json({
      message: 'Tạo người dùng thành công',
      user: { email: email, username: username, role: role || 'user' }
    });
  } catch (error) {
    console.error('Lỗi khi tạo người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi tạo người dùng: ' + error.message });
  }
});

// Route đăng nhập người dùng
router.post('/login', async (req, res) => {
  const { username, password } = req.body;

  try {
    // Tìm người dùng theo username
    const userSnapshot = await db.collection('users').where('username', '==', username).get();
    if (userSnapshot.empty) {
      return res.status(404).json({ message: 'Người dùng không tìm thấy' });
    }

    // Lấy tài liệu người dùng và ID
    const userDoc = userSnapshot.docs[0];
    const userData = userDoc.data();
    const email = userData.email;
    const uid = userDoc.id; // ID của tài liệu Firestore

    // So sánh mật khẩu
    const isMatch = await bcrypt.compare(password, userData.hashedPassword);
    if (!isMatch) {
      return res.status(401).json({ message: 'Mật khẩu không đúng' });
    }

    // Tạo token JWT
    const token = jwt.encode(
      { uid: uid, email: email, role: userData.role || 'user' },
      process.env.JWT_SECRET,
      'HS256',
      { expiresIn: process.env.JWT_EXPIRES_IN || '1h' }
    );

    // Gửi phản hồi
    res.status(200).json({
      message: 'Đăng nhập thành công',
      token: token,
      user: { email: email, uid: uid }
    });
  } catch (error) {
    console.error('Lỗi khi đăng nhập:', error.message);
    res.status(401).json({ message: 'Lỗi khi đăng nhập: ' + error.message });
  }
});

// Route bảo vệ với xác thực JWT
router.get('/token', authenticateJWT, (req, res) => {
  res.json({ message: 'Đây là thông tin bảo vệ', user: req.user });
});

// Route để xem tất cả người dùng
router.get('/users', authenticateJWT, checkRole('admin'), async (req, res) => {
  try {
    const snapshot = await collection.get();
    const users = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));
    res.json({ users });
  } catch (error) {
    console.error('Lỗi khi lấy người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi lấy người dùng: ' + error.message });
  }
});

// Lấy thông tin người dùng theo ID (chỉ dành cho admin)
router.get('/user/:id', authenticateJWT, checkRole('admin'), async (req, res) => {
  try {
    const userSnapshot = await collection.doc(req.params.id).get();
    if (!userSnapshot.exists) {
      return res.status(404).json({ message: 'User ID không tồn tại.' });
    }
    res.status(200).json({ id: userSnapshot.id, ...userSnapshot.data() });
  } catch (error) {
    console.error('Lỗi khi lấy thông tin người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi lấy thông tin người dùng: ' + error.message });
  }
});

router.put('/user/:id', authenticateJWT, checkRole('admin'), async (req, res) => {
  try {
    const user = req.body;
    await collection.doc(req.params.id).update(user);
    res.status(200).send('user update successfully');
  } catch (error) {
    res.status(500).send('Error updating user: ' + error.message);
  }
});

router.delete('/user/:id', authenticateJWT, checkRole('admin'), async (req, res) => {
  try {
    await collection.doc(req.params.id).delete();
    res.status(200).send("user delete successfully");
  } catch (error) {
    res.status(500).send(error.message);
  }
});

module.exports = router;
