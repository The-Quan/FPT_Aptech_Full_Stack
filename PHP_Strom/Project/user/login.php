<?php
$host = "localhost:3306";
$email = "root";
$password = "";
$database = "project";

$conn = new mysqli($host,$email,$password,$database);

$email =$_POST["email"];
$password =$_POST["password"];

$query = "select * from login where email = '$email' and password = '$password'";
$result = $conn->query($query);
if ($result->num_rows > 0){
    header("location:../Pages/home.php");
    exit();
}else{
    echo "dang nhap ko thanh cong";
}
$conn->close();
