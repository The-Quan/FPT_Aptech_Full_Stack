<?php
session_start();
// kiem tra neu nguoi dung chua dang nhap, chuyen huong ve trang dang nhap
if (!isset($_SESSION['user_id'])) {
    header( header: "Location: index.php");
    exit();
}
include 'StudentManager.php';
// ket noi den studentmanager
$studentManager = new StudentManager();
//lay danh sach sinh vien va thong tin diem
$students = $studentManager->getAllStudentWithMarks();
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/452/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Welcome, <?php echo $_SESSION['user_id']; ?>!</h2>
    <p>This is the main page after successful login.</p>
    <a href="logout.php" class="btn btn-danger">Logout</a>
    <h3>Student List</h3>
    <a href="add_student.php" class="btn btn-success mb-3">Add Student</a>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Action</th>
            <th>Mark Details</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $student): ?>
        <tr>
            <td><?php echo $student['id']; ?></td>
            <td><?php echo $student['username']; ?></td>
            <td><?php echo $student['address']; ?></td>
            <td>
                <a href="edit_student.php?id=<?php echo $student['id']; ?>" class="btn btn-warning btn-sm">Edit</a>
                <a href="delete_student.php?id=<?php echo $student['id']; ?>" class="btn btn-danger btn-sm"
                    onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
            </td>
            <td>
            <?php
            if ($student['mark_count'] > 0) {
            echo '<a href="mark_detail.php?student_id=' . $student['id'].'" class="btn btn-info btn-sm">Mark Details </a>';
            } else {
            echo '<button class="btn btn-info btn-sm" disabled>Mark Details</button>';
            }
            ?>
            </td>
        </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</div>
</body>
</html>
