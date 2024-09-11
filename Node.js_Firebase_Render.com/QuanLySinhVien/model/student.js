const express = require('express'); // Nạp module Express vào ứng dụng Node.js
const admin = require('firebase-admin'); // Nạp Firebase Admin SDK vào ứng dụng
require('dotenv').config(); // Nạp module dotenv và gọi phương thức config()

const app = express();
app.use(express.json()); // Để đọc dữ liệu JSON từ request body

// Kiểm tra các biến môi trường
if (!process.env.FIREBASE_PRIVATE_KEY || !process.env.FIREBASE_CLIENT_EMAIL || !process.env.FIREBASE_PROJECT_ID) {
    console.error('Missing Firebase environment variables');
    process.exit(1);
}

// Khởi tạo Firebase Admin SDK
admin.initializeApp({
    credential: admin.credential.cert({
        private_key: process.env.FIREBASE_PRIVATE_KEY ? process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n') : undefined,
        client_email: process.env.FIREBASE_CLIENT_EMAIL,
        project_id: process.env.FIREBASE_PROJECT_ID
    })
});

const db = admin.firestore(); // Trả về một đối tượng đại diện cho cơ sở dữ liệu Firestore
const collection = db.collection('students'); // Tham chiếu đến collection 'students' trong Firestore

// CRUD APIs

// 1. Get all students
app.get('/get-all-student', async (req, res) => {
    try {
        const snapshot = await collection.get();
        const students = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));
        res.status(200).json(students);
    } catch (error) {
        console.error('Error fetching students:', error); // Log lỗi chi tiết
        res.status(500).send('Error fetching students: ' + error.message);
    }
});


app.get('/student/:id', async (req, res) => {
    try {
        // Lấy dữ liệu từ cơ sở dữ liệu dựa trên id từ URL
        const data = await collection.doc(req.params.id).get();

        // Kiểm tra xem dữ liệu có tồn tại không
        if (!data.exists) {
            return res.status(404).send('Product not found');
        }

        // Gửi dữ liệu dưới dạng JSON
        res.status(200).json({ id: data.id, ...data.data() });
    } catch (error) {
        // Xử lý lỗi và gửi phản hồi lỗi
        res.status(500).send('Error fetching product: ' + error.message);
    }
});

app.post('/student', async (req, res) => {
    try {
      // Lấy dữ liệu sản phẩm từ thân của yêu cầu
      const product = req.body;
  
      // Thêm sản phẩm vào cơ sở dữ liệu và lấy tham chiếu tài liệu mới
      const docRef = await collection.add(product);
  
      // Gửi phản hồi thành công với ID của tài liệu mới và thông báo
      res.status(201).send({ id: docRef.id, message: 'Product created successfully' });
    } catch (error) {
      // Xử lý lỗi và gửi phản hồi lỗi
      res.status(500).send('Error creating product: ' + error.message);
    }
  });
  

app.put('/student/:id', async (req, res) => {
    try {
        // Lấy dữ liệu cập nhật từ thân của yêu cầu
        const updatedProduct = req.body;

        // Cập nhật tài liệu trong cơ sở dữ liệu dựa trên ID
        await collection.doc(req.params.id).update(updatedProduct);

        // Gửi phản hồi thành công
        res.status(200).send('Product updated successfully');
    } catch (error) {
        // Xử lý lỗi và gửi phản hồi lỗi
        res.status(500).send('Error updating product: ' + error.message);
    }
});


app.delete('/student/:id', async (req, res) => {
    try {
      // Xóa tài liệu trong cơ sở dữ liệu dựa trên ID
      await collection.doc(req.params.id).delete();
      
      // Gửi phản hồi thành công
      res.status(200).send('Product deleted successfully');
    } catch (error) {
      // Xử lý lỗi và gửi phản hồi lỗi
      res.status(500).send('Error deleting product: ' + error.message);
    }
  });
  

// Chạy server với port online hoặc 3000 local
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
