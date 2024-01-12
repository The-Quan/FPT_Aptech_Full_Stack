<?php
session_start();

if (!isset($_SESSION['user_id'])) {
    header(header: "Location: index.php");
    exit();
}
$studentManager = new StudentManager();
$markDetails = $studentManager->getMarkDetails();
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Mark Details</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Subject</th>
            <th>Mark</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($markDetails as $markDetail): ?>
        <tr>
            <td><?php echo $markDetail['student_id']; ?></td>
            <td><?php echo $markDetail['student_id']; ?></td>
            <td><?php echo $markDetail['subject']; ?></td>
            <td><?php echo $markDetail['mark']; ?></td>
        </tr>
        <?php endforeach; ?>
</body>
</html>
