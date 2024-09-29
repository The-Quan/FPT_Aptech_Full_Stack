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
          } else if (!room.board.includes("")) {
              room.gameActive = false;
              io.in(roomId).emit('gameOver', { winner: "draw" });
          } else {
              room.currentPlayer = room.currentPlayer === "X" ? "O" : "X"; // Chuyển lượt
          }
      }
    });
  
    socket.on('disconnect', () => {
      console.log('A user disconnected:', socket.id);
    });
  });
  