<?php
include 'StudentManager.php';
$studentManager = new StudentManager();

if (!isset($_GET['id'])){
    header('Location: students.php');
    exit;
}
$studentId = $_GET['id'];
$student = $studentManager->getStudentById($studentId);

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
    $name = $_POST['name'];
    $address = $_POST['address'];

    $studentManager->updateStudent($studentId, $name, $address);

    header('location: students.php');
    exit;
}
?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Edit Student</h2>
    <form method="post" action="">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name"
                   name="name" value="<?php echo $student['name']; ?>" required>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address"
                   name="address" value="<?php echo $student['address']; ?>" required>
        </div>
        <button type="submit" class="btn btn-primary">Update Student</button>
    </form>
</div>
</body>
</html>