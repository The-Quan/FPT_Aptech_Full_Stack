<?php
$servername= "localhost:3306";
$username="root";
$password="";
$dbname="fptaptechdb";

$conn = new mysqli($servername, $username, $password, $dbname);

if($conn->connect_error){
    die("connection failed: ". $conn->connect_error);
}