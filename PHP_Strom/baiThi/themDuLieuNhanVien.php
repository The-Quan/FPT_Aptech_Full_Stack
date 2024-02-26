<?php

include 'baiThiPHP.php';

$name = "Employee 1";
$startDate = "2024-01-01";
$totalLeaveDays = 5;
$workDaysInMonth = 20;
$exportRatio = 200;

$sql = "INSERT INTO employees (name, start_date, total_leave_days, work_days_in_month, export_ratio) VALUES ('$name', '$startDate', $totalLeaveDays, $workDaysInMonth, $exportRatio)";

if ($conn->query($sql) === TRUE) {
    echo "Employee added successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
