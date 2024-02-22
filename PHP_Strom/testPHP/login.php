<?php
$host = "localhost:3306";
$username = "root";
$password = "";
$database = "fptaptech";

$conn = new mysqli($host,$username,$password,$database);

$username =$_POST["username"];
$password =$_POST["password"];

$query = "select * from login where username = '$username' and password = '$password'";
$result = $conn->query($query);
if ($result->num_rows > 0){
    header("location:dashost.php");
    exit();
}else{
    echo "dang nhap ko thanh cong";
}
$conn->close();