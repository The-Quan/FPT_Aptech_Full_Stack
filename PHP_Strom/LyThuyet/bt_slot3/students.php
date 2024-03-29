<?php
// kiem tra thong tin dang nhap
session_start();
if (!isset($_SESSION['username'])){
    header("location: index.php");
    exit();
}

// ket noi danh sach sinh vien
include 'StudentManager.php';
$StudentManager = new StudentManager();

if (isset($_GET['action']) && $_GET['action'] === 'delete' && isset ($_GET['id'])){
    $StudentManager->deleteStudent($_GET['id']);
}
// lay danh sach sinh vien
$students = $StudentManager->getAllStudents();

?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>student list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Welcome, <?php echo $_SESSION['username']; ?>!</h2>
    <p>This is the main page after successful login.</p>

    <a href="logout.php" class="btn btn-danger">Logout</a>
    <h3>Student List</h3>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $student): ?>
        <tr>
            <td><?php echo $student['id']; ?></td>
            <td><?php echo $student['username']; ?></td>
        </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
</div>


<div class="container mt-5">
    <h2>Student List</h2>
    <a href="add_student.php" class="btn btn-success mb-3">Add Student</a>

    <table class="tabel">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $student): ?>
        <tr>
            <td><?php echo $student['id'] ?></td>
            </hr>
            <td><?php echo $student['username'] ?></td>
            </hr>
            <td><?php echo $student['address'] ?></td>
            </hr>
            <td>
                <a href="edit_student.php?id=<?php echo $student['id']; ?>"
                class="btn btn-warning btn-sm">Edit</a>
                <a href="students.php?action=delete&id=<?php echo $student['id']; ?>"
                class="btn btn-dager btn-sm" onclick="return
                confirm('Are you sure you want to delete this student?')">Delete</a>
            </td>
        </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
</div>
</body>
</html>

