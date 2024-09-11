const express = require('express');
const jwt = require('jwt-simple');
const bcrypt = require('bcryptjs');
require('dotenv').config(); // Nạp các biến môi trường
const admin = require('firebase-admin');

// Kiểm tra các biến môi trường cần thiết
if (!process.env.FIREBASE_PRIVATE_KEY || !process.env.FIREBASE_CLIENT_EMAIL || !process.env.FIREBASE_PROJECT_ID) {
  throw new Error('Các biến môi trường Firebase không được đặt đúng.');
}

// Khởi tạo Firebase Admin SDK (nên khởi tạo một lần)
if (admin.apps.length === 0) {
  admin.initializeApp({
    credential: admin.credential.cert({
      projectId: process.env.FIREBASE_PROJECT_ID,
      privateKey: process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n'),
      clientEmail: process.env.FIREBASE_CLIENT_EMAIL,
    }),
  });
}

const app = express();
app.use(express.json()); // Đảm bảo rằng middleware express.json() được sử dụng
const db = admin.firestore(); // Trả về một đối tượng đại diện cho cơ sở dữ liệu Firestore
const collection = db.collection('users');


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

// Middleware kiểm tra vai trò admin
const isAdmin = (req, res, next) => {
  const { role } = req.user;
  if (role === 'admin') {
    next();
  } else {
    return res.status(403).json({ message: 'Truy cập bị từ chối. Chỉ dành cho admin.' });
  }
};


// Route bảo vệ với xác thực JWT
app.get('/token', authenticateJWT, (req, res) => {
  res.json({ message: 'Đây là thông tin bảo vệ', user: req.user });
});

// Route đăng ký người dùng
app.post('/signup', async (req, res) => {
  const { email, password, username, role } = req.body;

  try {
    // Kiểm tra nếu email đã tồn tại
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
    // Kiểm tra nếu username đã tồn tại
    const usernameSnapshot = await db.collection('users').where('username', '==', username).get();
    if (!usernameSnapshot.empty) {
      return res.status(400).json({ message: 'Username đã được sử dụng' });
    }

    // Mã hóa mật khẩu
    const hashedPassword = await bcrypt.hash(password, 10);

    // Tạo người dùng mới trong Firebase Authentication
    const userRecord = await admin.auth().createUser({
      email: email,
      password: hashedPassword,  // Không cần mã hóa mật khẩu ở đây
      displayName: username,
    });

    // Gán vai trò cho người dùng
    await admin.auth().setCustomUserClaims(userRecord.uid, { role: role || 'user' });

    // Lưu thông tin người dùng vào Firestore
    const userRef = db.collection('users').doc(userRecord.uid);
    await userRef.set({
      email: email,
      username: username,
      role: role || 'user',
      hashedPassword: hashedPassword,  // Lưu mật khẩu đã mã hóa
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
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
      token: token,
    });
  } catch (error) {
    console.error('Lỗi khi tạo người dùng:', error);
    res.status(500).json({ message: 'Lỗi khi tạo người dùng: ' + error.message });
  }
});



// Route đăng nhập người dùng
app.post('/login', async (req, res) => {
  const { username, password } = req.body;

  try {
    // Tìm người dùng dựa trên username từ Firestore
    const userSnapshot = await db.collection('users').where('username', '==', username).get();
    if (userSnapshot.empty) {
      return res.status(404).json({ message: 'Người dùng không tìm thấy' });
    }

    const userDoc = userSnapshot.docs[0].data();
    const email = userDoc.email;
    const uid = userDoc.uid;

    // Kiểm tra mật khẩu (Bạn cần lưu hashedPassword trong Firestore khi đăng ký)
    const isMatch = await bcrypt.compare(password, userDoc.hashedPassword);
    if (!isMatch) {
      return res.status(401).json({ message: 'Mật khẩu không đúng' });
    }

    // Tạo token JWT
    const token = jwt.encode(
      { uid: uid, email: email, role: userDoc.role || 'user' },
      process.env.JWT_SECRET,
      'HS256',
      { expiresIn: process.env.JWT_EXPIRES_IN || '1h' }
    );

    res.status(200).json({
      message: 'Đăng nhập thành công',
      token: token,
      user: {
        email: email,
        uid: uid
      }
    });
  } catch (error) {
    console.error('Lỗi khi đăng nhập:', error.message);
    res.status(401).json({ message: 'Lỗi khi đăng nhập: ' + error.message });
  }
});


// Route để xem tất cả người dùng
app.get('/users', authenticateJWT, isAdmin, async (req, res) => {
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
app.get('/user/:id', authenticateJWT, isAdmin, async (req, res) => {
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

app.put('/user/:id', authenticateJWT, isAdmin, async (req, res) => {
  try {
    const user = req.body;
    await collection.doc(req.params.id,).update(user)
    res.status(200).send('user update successfully' )
  } catch (error) {
    res.status(500).send('Error updating user: ' + error.message);
  }
})
app.delete('/user/:id', authenticateJWT, isAdmin, async(req, res) => {
 try {
  await collection.doc(req.params.id).delete();
  res.status(200).send("user delete successfully ")
 } catch (error) {
  res.status(500).send(error.message)
 }
})

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server đang chạy trên cổng ${PORT}`);
});
