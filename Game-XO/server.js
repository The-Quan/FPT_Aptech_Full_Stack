require('dotenv').config();
const express = require('express');
const http = require('http');
const { Server } = require('socket.io');
const admin = require('firebase-admin');

// Cấu hình Firebase với các biến môi trường
admin.initializeApp({
  credential: admin.credential.cert({
    projectId: process.env.FIREBASE_PROJECT_ID,
    clientEmail: process.env.FIREBASE_CLIENT_EMAIL,
    privateKey: process.env.FIREBASE_PRIVATE_KEY.replace(/\\n/g, '\n'),
  }),
});

const db = admin.firestore();

const app = express();
const server = http.createServer(app);
const io = new Server(server);
const port = 3000;

const rooms = {}; // Quản lý các phòng

app.use(express.static(__dirname + '/public'));

io.on('connection', (socket) => {
  console.log('A user connected:', socket.id);

  // Xử lý sự kiện tạo phòng
  socket.on('createRoom', ({ roomId, playerName }) => {
    socket.join(roomId);

    if (!rooms[roomId]) {
      rooms[roomId] = {
        players: [],
        board: Array(9).fill(""),
        currentPlayer: "X",
        gameActive: true,
      };
    }

    rooms[roomId].players.push({ id: socket.id, name: playerName });
    io.in(roomId).emit('updateRoom', rooms[roomId]);

    console.log(`Room ${roomId} created by ${playerName}`);

    if (rooms[roomId].players.length === 2) {
      io.in(roomId).emit('startGame', {
        message: `Trò chơi bắt đầu! ${rooms[roomId].players[0].name} là người đi trước.`,
      });
    }
  });

  // Xử lý sự kiện tham gia phòng
  socket.on('joinRoom', ({ roomId, playerName }) => {
    socket.join(roomId);

    if (!rooms[roomId]) {
      rooms[roomId] = {
        players: [],
        board: Array(9).fill(""),
        currentPlayer: "X",
        gameActive: true,
      };
    }

    rooms[roomId].players.push({ id: socket.id, name: playerName });
    io.in(roomId).emit('updateRoom', rooms[roomId]);

    console.log(`Player ${playerName} joined room ${roomId}`);

    if (rooms[roomId].players.length === 2) {
      io.in(roomId).emit('startGame', {
        message: `Trò chơi bắt đầu! ${rooms[roomId].players[0].name} là người đi trước.`,
      });
    }
  });

  // Lắng nghe sự kiện 'restartGame' từ client
  socket.on('restartGame', (roomId) => {
    const room = rooms[roomId];
    if (room) {
      // Reset trạng thái của trò chơi
      room.board = Array(9).fill("");
      room.currentPlayer = "X";
      room.gameActive = true;

      // Gửi thông tin reset tới tất cả người chơi trong phòng
      io.in(roomId).emit('updateBoard', room.board);
      io.in(roomId).emit('startGame', {
        message: `Trò chơi bắt đầu lại! ${room.players[0].name} là người đi trước.`,
      });
    }
  });

  // Xử lý nước đi của người chơi
  socket.on('makeMove', ({ roomId, index }) => {
    const room = rooms[roomId];
    if (room && room.gameActive && room.board[index] === "") {
      room.board[index] = room.currentPlayer; // Cập nhật nước đi
      io.in(roomId).emit('updateBoard', room.board); // Phát đi cập nhật bảng cho tất cả người chơi

      // Kiểm tra thắng hoặc hòa
      if (checkWinner(room.board)) {
        room.gameActive = false;
        io.in(roomId).emit('gameOver', { winner: room.currentPlayer });
        saveGameResult(roomId, room.currentPlayer);
      } else if (!room.board.includes("")) {
        room.gameActive = false;
        io.in(roomId).emit('gameOver', { winner: "draw" });
        saveGameResult(roomId, "draw");
      } else {
        room.currentPlayer = room.currentPlayer === "X" ? "O" : "X"; // Chuyển lượt
      }
    }
  });

  socket.on('disconnect', () => {
    console.log('A user disconnected:', socket.id);
  });
});

// Hàm kiểm tra điều kiện thắng
function checkWinner(board) {
  const winConditions = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];

  for (let condition of winConditions) {
    const [a, b, c] = condition;
    if (board[a] && board[a] === board[b] && board[a] === board[c]) {
      return true; // Trả về true nếu có người thắng
    }
  }
  return false; // Trả về false nếu chưa có ai thắng
}

// Hàm lưu kết quả game vào Firebase
function saveGameResult(roomId, winner) {
  const room = rooms[roomId];
  db.collection('games').add({
    roomId: roomId,
    winner: winner === "draw" ? "Hòa" : winner,
    players: room.players.map(p => p.name),
    timestamp: new Date(),
  });
}

server.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
