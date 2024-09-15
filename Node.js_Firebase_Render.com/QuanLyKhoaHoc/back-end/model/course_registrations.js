const express = require('express');
const admin = require('../config/firebase');
const router = express.Router();
const db = admin.firestore();
const collection = db.collection('course_registrations');
const { authenticateJWT, checkRole } = require('../config/authentication');

// Lấy tất cả các đăng ký khóa học
router.get('/', authenticateJWT, checkRole('admin', 'user'), async (req, res) => {
    try {
        const getAll = await collection.get();
        const data = getAll.docs.map(doc => ({ id: doc.id, ...doc.data() }));
        res.json({ data });
    } catch (error) {
        res.status(500).json({ message: error });
    }
});

// Lấy thông tin đăng ký khóa học theo username
router.get('/:userId', authenticateJWT, checkRole('admin', 'user'), async (req, res) => {
    try {
        const userId = req.params.userId;

        // Kiểm tra nếu không có uid trong request
        if (!userId) {
            return res.status(400).json({ message: 'UID không tồn tại trong request.' });
        }

        // Tìm kiếm thông tin đăng ký khóa học theo uid
        const getByUID = await collection.where('userId', '==', userId).get();

        // Kiểm tra nếu không có kết quả
        if (getByUID.empty) {
            return res.status(404).json({ message: `Người dùng với UID là '${userId}' không tìm thấy` });
        }

        const data = getByUID.docs.map(doc => ({ id: doc.id, ...doc.data() }));
        res.json({ data });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
});


// Đăng ký khóa học
router.post('/', authenticateJWT, checkRole('user'), async (req, res) => {
    try {
        const { courseId } = req.body; // Lấy thông tin khóa học từ yêu cầu
        const userId = req.user.uid; // Lấy thông tin người dùng từ token JWT

        // Kiểm tra xem khóa học có tồn tại không
        const courseDoc = await db.collection('course').doc(courseId).get(); // Sửa 'course' thành 'courses'
        if (!courseDoc.exists) {
            return res.status(404).json({ message: 'Khóa học không tồn tại' });
        }

        // Kiểm tra xem người dùng đã đăng ký khóa học này chưa
        const existingRegistration = await collection
            .where('courseId', '==', courseId)
            .where('userId', '==', userId)
            .get();

        if (!existingRegistration.empty) {
            return res.status(400).json({ message: 'Bạn đã đăng ký khóa học này' });
        }

        // Tạo bản ghi đăng ký khóa học
        await collection.add({
            userId,
            courseId,
            registrationDate: new Date()
        });

        res.status(201).send({ message: "Course registered successfully" });
    } catch (error) {
        console.error('Error during course registration:', error.message);
        res.status(500).json({ message: 'Error during course registration: ' + error.message });
    }
});

module.exports = router;
