<?php
$host="localhost:3306";
$Username="root";
//$Email="";
$Password="";
$database="quanfpt";

$conn = new mysqli($host, $Username, $Password, $database);

if($conn->connect_error){
    echo "thanh cong";
}else{
    echo "ko thanh cong";
}