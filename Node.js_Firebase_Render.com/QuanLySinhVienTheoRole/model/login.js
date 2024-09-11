const express = require('express');
const jwt = require('jwt-simple');
const bcrypt = require('bcryptjs');
require('dotenv').config(); // Nạp các biến môi trường
const admin = require('firebase-admin');

const app = express();
app.use(express.json()); // Đảm bảo rằng middleware express.json() được sử dụng

// Khởi tạo Firebase Admin SDK
admin.initializeApp({
  credential: admin.credential.cert({
    projectId: process.env.FIREBASE_PROJECT_ID,
    privateKey: process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n'),
    clientEmail: process.env.FIREBASE_CLIENT_EMAIL,
  }),
});

// Khởi tạo Firestore
const db = admin.firestore();

// Middleware xác thực JWT
const authenticateJWT = (req, res, next) => {
  const authHeader = req.headers.authorization;

  if (authHeader) {
    const token = authHeader.split(' ')[1];

    try {
      const decoded = jwt.decode(token, process.env.JWT_SECRET);
      req.user = decoded; // Lưu thông tin người dùng vào req
      next();
    } catch (err) {
      return res.status(403).json({ message: 'Token không hợp lệ' });
    }
  } else {
    res.status(401).json({ message: 'Thiếu header Authorization' });
  }
};

// Route đăng ký người dùng
app.post('/signup', async (req, res) => {
  const { email, password, username, role } = req.body;

  try {
    // Tạo người dùng mới trong Firebase Authentication
    const userRecord = await admin.auth().createUser({
      email: email,
      password: password,
      displayName: username
    });

    // Gán vai trò cho người dùng
    await admin.auth().setCustomUserClaims(userRecord.uid, { role: role || 'user' });

    // Lưu thông tin người dùng vào Firestore
    const userRef = db.collection('users').doc(userRecord.uid);
    await userRef.set({
      email: email,
      username: username,
      role: role || 'user',
      createdAt: admin.firestore.FieldValue.serverTimestamp()
    });

    // Tạo token JWT cho người dùng mới
    const token = jwt.encode(
      { uid: userRecord.uid, email: email, role: role || 'user' },
      process.env.JWT_SECRET,
      'HS256',
      { expiresIn: process.env.JWT_EXPIRES_IN || '1h' }
    );

    res.status(201).json({
      message: 'Tạo người dùng thành công',
      user: { email: email, username: username, role: role || 'user' },
      token: token
    });
  } catch (error) {
    console.error('Lỗi khi tạo người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi tạo người dùng: ' + error.message });
  }
});

// Route để xem tất cả người dùng
app.get('/users', async (req, res) => {
  try {
    const snapshot = await db.collection('users').get();
    const users = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));

    res.json({ users });
  } catch (error) {
    console.error('Lỗi khi lấy người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi lấy người dùng: ' + error.message });
  }
});

// Route bảo vệ với xác thực JWT
app.get('/protected', authenticateJWT, (req, res) => {
  res.json({ message: 'Đây là thông tin bảo vệ', user: req.user });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server đang chạy trên cổng ${PORT}`);
});
