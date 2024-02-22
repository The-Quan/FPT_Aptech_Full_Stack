<?php
$host = "localhost: 3306";
$username = "root";
$password = "";
$dbname = "quanfpt";

$conn = new mysqli($host, $username, $password, $dbname);

if($conn->connect_error){
    die("ket noi ko thanh cong:" . $conn->connect_error);
}
echo "ket noi thanh cong";