const express = require('express');
const admin = require('firebase-admin');
require('dotenv').config();
const cors = require('cors'); 



const app = express();
app.use(express.json());

app.use(cors({
    origin: 'http://localhost:3000' // Replace with your React app URL
  }));
  
admin.initializeApp({
    credential: admin.credential.cert({
      private_key: process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n'),
      client_email: process.env.FIREBASE_CLIENT_EMAIL,
      project_id: process.env.FIREBASE_PROJECT_ID,
    }),
  });

const db = admin.firestore();
const collection = db.collection('Tree_Shop');

app.get('/get', async(req, res) => {
    try {
        const get = await collection.get();
        const data = get.docs.map(doc => ({id: doc.id, ...doc.data() }) )
        res.status(200).json({data});
    } catch (error) {
        
    }
})

app.post('/post', async(req, res) => {
   try {
    const {  name, img, description} = req.body;

    const data = await collection.add({
        name,
        img,
        description
    });
    
    res.status(201).send({ message: "Course created successfully", id: data.id });
   } catch (error) {
    console.error('Error creating course:', error.message);
    res.status(500).json({ message: 'Error creating course: ' + error.message });
   }
})

app.put('/:id', async(req, res) =>{
try {
    const put = req.body;
    await collection.doc(req.params.id).update(put);
    res.status(200).send("course update successfully");
} catch (error) {
    res.status(500).send({ message: error })
}
})

app.delete('/:id', async(req, res) =>{
    try {
        await collection.doc(req.params.id).delete();
    res.status(200).send('Course deleted successfully');
    } catch (error) {
        res.status(500).send({ message: "Error" });
    }
})


const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});