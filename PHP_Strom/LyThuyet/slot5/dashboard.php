
<?php
global $conn;
include 'config.php';
// them sinh vien
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_student"])) {
    $id = $_POST["id"];
    $name = $_POST["name"];
    $address = $_POST['address'];

    $sql = "INSERT INTO Students (id, name, address) VALUES ('$id', '$name', '$address')";
    $conn->query($sql);
}

// them mon hoc
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_subject"])) {
    $subject_name = $_POST["subject_name"];

    $sql = "INSERT INTO Subjects (name) VALUES ('$subject_name')";
    $conn->query($sql);
}

// them diem
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_mark"])) {
    $student_id = $_POST["student_id"];
    $subject_id = $_POST["subject_id"];
    $mark = $_POST["marks"];

    $sql = "INSERT INTO marks (student_id, subject_id, mark) VALUES ('$student_id', '$subject_id', '$mark')";
    $conn->query($sql);
}

// hien thi danh sach
$sql_students = "SELECT * FROM students";
$result_students = $conn->query($sql_students);

// hien thi danh sach mon hoc
$sql_subjects = "SELECT * FROM subjects";
$result_subjects = $conn->query($sql_subjects);

// hien thi danh sach diem
$sql_marks = "SELECT marks.id, Students.name as student_name, Subjects.name as subject_name, mark FROM marks
              JOIN Students ON marks.student_id = Students.id
              JOIN Subjects ON marks.subject_id = Subjects.id";
$result_marks = $conn->query($sql_marks);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>slot5</title>
</head>
<body>
<h2>Thêm sinh viên</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    Id: <input type="text" id="id" name="id" required>
    Tên: <input type="text" name="name" required>
    Địa chỉ: <input type="text" name="address" required>
    <input type="submit" name="add_student" value="Thêm">
</form>

<h2>Thêm môn học</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    Tên môn học: <input type="text" name="subject_name" required>
    <input type="submit" name="add_subject" value="Thêm">
</form>

<h2>Thêm điểm</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    Sinh viên:
    <select name="student_id">
        <?php while ($row = $result_students->fetch_assoc()): ?>
            <option value="<?php echo $row['id']; ?>"><?php echo $row['name']; ?></option>
        <?php endwhile; ?>
    </select>
    Môn học:
    <select name="subject_id">
        <?php while ($row = $result_subjects->fetch_assoc()): ?>
            <option value="<?php echo $row['id']; ?>"><?php echo $row['name']; ?></option>
        <?php endwhile; ?>
    </select>
    Điểm: <input type="text" name="marks" required>
    <input type="submit" name="add_mark" value="Thêm">
</form>

<h2>Danh sách điểm sinh viên</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Sinh Viên</th>
        <th>Môn học</th>
        <th>Điểm</th>
    </tr>
    <?php while ($row = $result_marks->fetch_assoc()): ?>
        <tr>
            <td><?php echo $row['id']; ?></td>
            <td><?php echo $row['student_name']; ?></td>
            <td><?php echo $row['subject_name']; ?></td>
            <td><?php echo $row['mark']; ?></td>
        </tr>
    <?php endwhile; ?>
</table>
</body>
</html>
