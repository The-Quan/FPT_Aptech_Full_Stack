const socket = io();
let playerName;
let roomId;
let gameBoard;
let gameActive = false;

// Function để người chơi tham gia phòng
function joinRoom() {
    playerName = document.getElementById("playerName").value;
    roomId = document.getElementById("roomId").value;

    if (playerName && roomId) {
        socket.emit("joinRoom", { roomId, playerName });
        document.getElementById("joinRoom").classList.add("hidden");
        document.getElementById("gameBoardContainer").classList.remove("hidden");
        document.getElementById("roomIdDisplay").textContent =` Phòng: ${roomId}`;
    }
}

// Nhận dữ liệu cập nhật bảng cờ từ server
socket.on("updateBoard", (board) => {
    const gameBoardElement = document.getElementById("gameBoard");
    gameBoardElement.innerHTML = ""; // Clear previous board
    board.forEach((cell, index) => {
        const cellDiv = document.createElement("div");
        cellDiv.classList.add("cell");
        cellDiv.textContent = cell; // Hiển thị X hoặc O
        cellDiv.addEventListener("click", () => makeMove(index)); // Gửi nước đi khi click
        gameBoardElement.appendChild(cellDiv);
    });
});

// Gửi nước đi lên server
function makeMove(index) {
    if (gameActive) {
        socket.emit("makeMove", { roomId, index });
    }
}

// Lắng nghe sự kiện bắt đầu game
socket.on("startGame", ({ message }) => {
    console.log("Trò chơi bắt đầu:", message);
    document.getElementById("gameStatus").textContent = message;
    gameActive = true;

    // Hiển thị bảng cờ lần đầu
    gameBoard = Array(9).fill("");
    const gameBoardElement = document.getElementById("gameBoard");
    gameBoardElement.innerHTML = ""; // Xóa bảng cũ nếu có
    gameBoard.forEach((cell, index) => {
        const cellDiv = document.createElement("div");
        cellDiv.classList.add("cell");
        cellDiv.addEventListener("click", () => makeMove(index));
        gameBoardElement.appendChild(cellDiv);
    });
});


// Lắng nghe sự kiện game kết thúc
socket.on("gameOver", ({ winner }) => {
    if (winner === "draw") {
        document.getElementById("gameStatus").textContent = "Trận đấu hòa!";
    } else {
        document.getElementById("gameStatus").textContent = `${winner} thắng!`;
    }
    gameActive = false;

    // Hiển thị nút restart game sau khi game kết thúc
    document.getElementById("restartButton").classList.remove("hidden");
});

// Hàm để khởi động lại game (nếu cần)
function restartGame() {
    gameBoard = Array(9).fill("");
    gameActive = true;
    document.getElementById("gameStatus").textContent = "";
    socket.emit("restartGame", roomId); // gửi yêu cầu khởi động lại tới server
}

