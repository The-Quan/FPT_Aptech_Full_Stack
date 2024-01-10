<?php
$host ="localhost:3306";
$username="root";
$password ="";
$database = "quanfpt";
// kết nối csdl
$conn = new mysqli($host, $username, $password, $database);
//kiểm tra kết nối có thành công hay không
if($conn->connect_error){
    die("kết nối đến csdl ko thành công".$conn->connect_error);
}else
    echo "kết nối CSDL thành công";

//đóng kết nối đến csdl sau khi thực thi
$conn->close();