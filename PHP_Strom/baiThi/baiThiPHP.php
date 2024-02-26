<?php
$host = "localhost: 3306";
$username ="root";
$password ="";
$dbname = "employee_performance";

$conn = new mysqli($host, $username, $password, $dbname);

if ($conn->connect_error){
    die("Connection failed: ".$conn->connect_error);
}