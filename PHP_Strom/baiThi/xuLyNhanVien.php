<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee information results</title>
</head>
<body>
<h1>Employee information results</h1>

<?php
include 'thongTinNhanVien.php';
include 'baiThiPHP.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $startDate = $_POST['startDate'];
    $totalLeaveDays = $_POST['totalLeaveDays'];
    $workDaysInMonth = $_POST['workDaysInMonth'];
    $exportRatio = $_POST['exportRatio'];

    $sql = "INSERT INTO employees (name, start_date, total_leave_days, work_days_in_month, export_ratio) VALUES ('$name', '$startDate', $totalLeaveDays, $workDaysInMonth, $exportRatio)";

    if ($conn->query($sql) === TRUE) {
        echo "<p>Employee <strong>$name</strong> added successfully.</p>";
        echo "<p>Details:</p>";
        echo "<ul>";
        echo "<li>Name: $name</li>";
        echo "<li>Start Date: $startDate</li>";
        echo "<li>Total Leave Days: $totalLeaveDays</li>";
        echo "<li>Work Days in Month: $workDaysInMonth</li>";
        echo "<li>Export Ratio: $exportRatio</li>";
        echo "</ul>";
    } else {
        echo "<p>Error: " . $sql . "<br>" . $conn->error . "</p>";
    }
}

$conn->close();
?>


</body>
</html>
