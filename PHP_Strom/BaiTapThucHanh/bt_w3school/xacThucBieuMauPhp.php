<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>xacThucBieuMau</title>
</head>
<body>
<?php
// định nghĩa các biến và đặt thành các giá trị rỗng
$name = $email = $gender = $comment =$website = "";

if($_SERVER["REQUEST_METHOD"] == "POST"){
    $name = test_input($_POST["name"]);
    $email = test_input($_POST["email"]);
    $website = test_input($_POST["website"]);
    $comment = test_input($_POST["comment"]);
    $gender = test_input($_POST["gender"]);
}
function test_input($data){
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}
?>

<h2>PHP form Validation Example</h2>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
    name: <input type="text" name="name"><br><br>
    email: <input type="text" name="email"><br><br>
    Website: <input type="text" name="website"><br><br>
    comment: <textarea name="comment" cols="40" rows="5"></textarea><br><br>
    gender:
    <input type="radio" name="gender" value="female">Female
    <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="other">Other
    <br><br>
    <input type="submit" name="submit" value="submit">
</form>

<?php
echo "<h2>Your Input:</h2>";
echo $name;
echo "<br>";
echo $email;
echo "<br>";
echo $website;
echo "<br>";
echo $comment;
echo "<br>";
echo $gender;
echo "<br>";

?>
</body>
</html>