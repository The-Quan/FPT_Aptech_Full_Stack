<?php
$servername="localhost: 3306";
$username= "root";
$password="";
$dbname="fptaptechdb";

$conn = new mysqli($servername, $username, $password);
if ($conn ->connect_error){
    die("connection faiL:". $conn->connect_error);
}else{
    echo "thanh cong";
}
