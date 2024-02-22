<?php
include "connect.php";
if(isset($_POST['btn-reg'])){
    echo "da submit";
    echo "<pre>";
    print_r($_POST);
    $username = $_POST['username'];
    $fullname = $_POST['fullname'];
    $password = $_POST['password'];
    $email = $_POST['email'];
    $address = $_POST['address'];
    $gender = $_POST['gender'];
}

