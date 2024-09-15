const express = require('express');
const admin = require('../config/firebase')
const { authenticateJWT, checkRole } = require('../config/authentication')
const router = express.Router();
const db = admin.firestore();
const collection = db.collection('course')

router.get('/', async (req, res) => {
    try {
        const getAll = await collection.get();
        const data = getAll.docs.map(doc => ({ id: doc.id, ...doc.data() }));
        res.json({ data });
    } catch (error) {
        res.status(500).json({ message: error })
    }
})
router.get('/:id', authenticateJWT, checkRole('admin', 'user'), async (req, res) => {
    try {
        const course = await collection.doc(req.params.id).get();
        if (!course.exists) {
            return res.status(404).json({ message: 'course ID không tồn tại.' });
        }
        res.status(200).json({ id: course.id, ...course.data() });
    } catch (error) {
        res.status(500).json({ message: error })
    }
})

router.post('/', authenticateJWT, checkRole('admin'), async (req, res) => {
    try {
        const { name, description, instructor, price, image } = req.body;

        const existing = await collection
            .where('name', '==', name).get();

        if (!existing.empty) {
            return res.status(400).json({ message: 'Khóa học này đã có' });
        }

        // Thêm dữ liệu vào collection courses
        const courseRef = await collection.add({
            name,
            description,
            instructor,
            price,
            image
        });

        res.status(201).send({ message: "Course created successfully", id: courseRef.id });
    } catch (error) {
        console.error('Error creating course:', error.message);
        res.status(500).json({ message: 'Error creating course: ' + error.message });
    }
});


router.put('/:id', authenticateJWT, checkRole('admin'), async (req, res) => {
    try {
        const put = req.body;
        data = await collection.doc(req.params.id).update(put);
        res.status(200).send("course update successfully");
    } catch (error) {
        res.status(500).send({ message: error })
    }
})
router.delete('/:id', authenticateJWT, checkRole('admin'), async (req, res) => {
    try {
        await collection.doc(req.params.id).delete();
        res.status(200).send('Course deleted successfully');
    } catch (error) {
        res.status(500).send({ message: "Error" });
    }
});


module.exports = router;
