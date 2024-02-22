<?php
$host ="localhost:3306";
$username="root";
$password ="";
$database = "fptaptech";
// kết nối csdl
$conn = new mysqli($host, $username, $password, $database);
////kiểm tra kết nối có thành công hay không
//if($conn->connect_error){
//    die("kết nối đến csdl ko thành công".$conn->connect_error);
//}
// xử lý phần login
$username = $_POST["username"];
$password = $_POST["password"];

// thực hiện truy vấn thông tin đăng nhập
$query = "select * from login where username = '$username' and password='$password'";
$result = $conn->query($query); //
if($result->num_rows>0){
    echo "đăng nhập thành công";
    header("location:dashboard.php"); //điều hướng sang dashboard.php nếu login thành công.
    exit;
}else{
    echo "đăng nhập ko thành công. vui lòng thử lại";
}
//đóng kết nối sau khi đã thực hiện xong
$conn->close();

