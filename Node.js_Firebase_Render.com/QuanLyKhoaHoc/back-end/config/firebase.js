// firebase.js
const admin = require('firebase-admin');
require('dotenv').config();

// Kiểm tra nếu Firebase Admin SDK đã được khởi tạo
if (!admin.apps.length) {
  admin.initializeApp({
    credential: admin.credential.cert({
      private_key: process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n'),
      client_email: process.env.FIREBASE_CLIENT_EMAIL,
      project_id: process.env.FIREBASE_PROJECT_ID
    })
  });
  console.log('Firebase Admin SDK initialized successfully');
} else {
  console.log('Firebase Admin SDK already initialized');
}

module.exports = admin;
