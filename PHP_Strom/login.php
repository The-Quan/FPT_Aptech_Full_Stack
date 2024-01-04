<?php
session_start();
if($_SERVER["REQUEST_METHOD"]=="POST"){
    $validUsername = "admin";
    $validPassword = "admin123";
    // lấy dữ liệu từ from login (index.html)
    $enteredUsername = $_POST ["username"];
    $enteredPassword = $_POST ["password"];
    if($enteredUsername == $validUsername && $enteredPassword == $validPassword){
        //nếu đúng username và password thì mời sang trang có tên là:dashboard
        $_SESSION["username"] = $enteredUsername;
        header( "Location: dashboard.php");
        exit();
    }else{
        echo "sai username or password. moi thu lai";
    }
}