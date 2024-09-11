const express = require('express');
const jwt = require('jwt-simple');
const bcrypt = require('bcryptjs');
require('dotenv').config(); // Nạp các biến môi trường

const app = express();
app.use(express.json()); // Đảm bảo rằng middleware express.json() được sử dụng

// Giả sử bạn có một cơ sở dữ liệu người dùng (ví dụ: sử dụng một đối tượng hoặc cơ sở dữ liệu thực tế)
let users = [];

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
  const { email, password, username } = req.body;

  try {
    // Kiểm tra nếu người dùng đã tồn tại
    const existingUser = users.find(user => user.email === email);
    if (existingUser) {
      return res.status(400).json({ message: 'Người dùng đã tồn tại' });
    }

    // Mã hóa mật khẩu
    const hashedPassword = await bcrypt.hash(password, 10);

    // Tạo người dùng mới
    const newUser = { email, username, password: hashedPassword };
    users.push(newUser);

    // Tạo token JWT cho người dùng mới
    const token = jwt.encode(
      { email: newUser.email, username: newUser.username },
      process.env.JWT_SECRET,
      'HS256',
      { expiresIn: process.env.JWT_EXPIRES_IN || '1h' }
    );

    res.status(201).json({
      message: 'Tạo người dùng thành công',
      user: { email: newUser.email, username: newUser.username },
      token: token // Trả về token JWT
    });
  } catch (error) {
    console.error('Lỗi khi tạo người dùng:', error); // Log lỗi chi tiết
    res.status(500).json({
      message: 'Lỗi khi tạo người dùng: ' + error.message
    });
  }
});

// Ví dụ sử dụng middleware authenticateJWT cho route bảo vệ
app.get('/protected', authenticateJWT, (req, res) => {
  res.json({ message: 'Đây là thông tin bảo vệ', user: req.user });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server đang chạy trên cổng ${PORT}`);
});
