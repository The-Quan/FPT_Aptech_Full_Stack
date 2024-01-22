<?php
$host ="localhost:3306";
$Username="root";
$Email="root";
$Password ="";
$database = "quanfpt";
// kết nối csdl
$conn = new mysqli($host, $Username,$Email, $Password, $database);
//kiểm tra kết nối có thành công hay không
if($conn->connect_error){
    die("kết nối đến csdl ko thành công".$conn->connect_error);
}
// xử lý phần login
$username =$_POST["Username"];
$Email = $_POST['Email'];
$password =$_POST["Password"];

// thực hiện truy vấn thông tin đăng nhập

$query = "select * from account whthực hiện truy vẫn đến cơ sở dữ liệu server
ere username = 'username' and password='password'";
$result = $conn->query($query); //
if($result->num_rows>0){
    echo "đăng nhập thành công";
    header("location:dashboard.php"); //điều hướng sang dashboard.php nếu login thành công.
}else{
    echo "đăng nhập ko thành công. vui lòng thử lại";
}
//đóng kết nối sau khi đã thực hiện xong
$conn->close();

