<?php
global $conn;
include 'config.php';

//1. thêm sinh viên

if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_student"])){
    $id = $_POST["id"];
    $name = $_POST["name"];
    $address = $_POST["address"];
    // insert sql engine
    $sql = "INSERT INTO Students(id,name, address) values ('$id','$name','$address')";
    $conn->query($sql);
}
// hien thi danh sach sinh vien
$sql_student= "SELECT * FROM Students ";
$result_student = $conn->query($sql_student);

// hien thi danh sach mon hocj

$sql_subject = "select * from subject";
$result_subject = $conn->query($sql);

//2. thêm môn học

if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_subject"])){

}
//3. vào điểm cho học sinh viên

if($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["add_mark"])) {
    $student_id = $_POST["student_id"];
    $subject_id_id = $_POST["subject_id"];
    $marks = $_POST["marks"];
}
//4. hiển thị thông tin chi tiết: sinh viên, môn học, điểm.
?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>student Management</title>
</head>
<body>
<h2> them sinh vien</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF'] ?>">
    Ten: <input type="text" name="name" required>
    dia chi: <input type="text" name="name" required>
    <input type="submit" name="add_name" value="Them">
</form>
<h2>them mon hoc</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF'] ?>">
    Ten Mon: <input type="text" name="name" required>

    <input type="submit" name="add_mark" value="Them">
</form>
<h2> them diem</h2>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF'] ?>">
    sinh vien:
    <select name="student_id">
        <?php while ($row = $result_student-> fetch_assoc()): ?>
        <option value="<?php echo $row['id']; ?><?php echo $row['name']; ?>"></option>
        <?php endwhile; ?>
    </select>
    <input type="submit" name="add_mark" value="Them">
</form>
</body>
</html>