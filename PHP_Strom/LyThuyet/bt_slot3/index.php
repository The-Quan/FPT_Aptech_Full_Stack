<?php
session_start();

if(isset($_SESSION['user_id'])){
    header('location: dashboard.php');
    exit();
}
if($_SERVER["REQUEST_METHOD"] == "POST"){
    include "StudentManager.php";
    $studentManager = new StudentManager();

    $username = $_POST["username"];
    $password = $_POST["password"];

    $sql = "SELECT * FROM Account WHERE username=? AND password=?";
    $stmt = $studentManager ->conn->prepare($sql);
    $stmt->bind_param("ss", $username, $password);
    $stmt->execute();

    $result = $stmt->get_result();

    if ($result->num_rows == 1){
        $row = $result->fetch_assoc();
        $_SESSION['user_id']=$row['id'];

        header("Location: dashboard.php ");
        exit();
    }else{
        $error_message = "đăng nhập ko thành công. vui long kiểm tra lại tên đằng nhập và mật khẩu.";
    }
    $stmt->close();
}
?>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Login</h2>
    <?php
    if (isset($error_message)){
        echo '<div class="alert alert-danger">'. $error_message . '</div>';
    }
    ?>

    <form method="post" action="">
        <div class="form_group">
            <label for="username">Username: </label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form_group">
            <label for="password">Password: </label>
            <input type="text" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">login</button>
    </form>

    <h2>Student Management System</h2>
    <a href="students.php" class="btn btn-primary">View Students</a>
</div>
</body>
</html>