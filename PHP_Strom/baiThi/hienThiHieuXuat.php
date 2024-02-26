<?php

include 'baiThiPHP.php';
include 'tinhDiemHieuXuat.php';
include 'laydulieunhanvien.php';


$sql = "SELECT * FROM employees";
$result = $conn->query($sql);

echo "<h1>Employee Performance Tracker</h1>";

while ($row = $result->fetch_assoc()) {
    $performance = calculatePerformance($row['total_leave_days'], $row['work_days_in_month'], $row['export_ratio']);
    echo "<p>{$row['name']} - Performance: {$performance}</p>";
}

$conn->close();