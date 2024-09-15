const express = require('express');
require('dotenv').config(); // Nạp các biến môi trường
const authRoutes = require('./model/access_authentication');
const course = require('./model/course')
const course_registrations = require('./model/course_registrations');
const cors = require('cors'); 

const app = express();
app.use(express.json()); // Để đọc dữ liệu JSON từ request body

// Kiểm tra các biến môi trường
if (!process.env.FIREBASE_PRIVATE_KEY || !process.env.FIREBASE_CLIENT_EMAIL || !process.env.FIREBASE_PROJECT_ID) {
  console.error('Missing Firebase environment variables');
  process.exit(1);
}

app.use(cors({
  origin: 'http://localhost:3000' // Replace with your React app URL
}));

// Sử dụng các route
app.use('/', authRoutes);

app.use('/course', course)

app.use('/course_registrations', course_registrations)


const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Server đang chạy trên cổng ${PORT}`);
});
