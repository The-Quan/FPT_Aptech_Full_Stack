const { Socket } = require('dgram');
const  express = require('express')
const http = require('http');
const {Server} = require('socket.io')

const app = express();
const server = http.createServer(app);

const io = new Server(server);

app.get('/', (req, res) =>{
    res.sendFile(__dirname + '/index.html')
});

io.on('connection', (socket) =>{
    console.log('Nguoi dung da ket noi')
    // lăng nghe sự kiện chat từ client 
    socket.on('chat message', (msg)=>{
     io.emit('chat message', msg)
    })
    //lăng nghe sự kiển 'Typing' từ client
    socket.on('typing', ()=>{
        socket.broadcast.emit('typing'); // thông báo cho mọi người
    })
socket.on('disconnect', ()=>{
    console.log('người dùng đã kết nối')
})
})
server.listen(3000, ()=>{
    console.log('server run 3000');
})