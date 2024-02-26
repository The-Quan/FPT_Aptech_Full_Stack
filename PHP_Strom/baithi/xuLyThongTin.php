<?php

// Kết nối đến cơ sở dữ liệu (thay đổi thông tin kết nối của bạn)
$host = "localhost";
$username = "root";
$password = "";
$dbname = "employee_performance";

$conn = new mysqli($host, $username, $password, $dbname);

// Kiểm tra kết nối
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Lấy dữ liệu từ form
$name = $_POST['name'];
$vacation_days = $_POST['vacation_days'];
$working_days = $_POST['working_days'];
$rate_per_day = $_POST['rate_per_day'];

// Tính điểm hiệu suất
$max_vacation_days = 12;
$performance_score = ($max_vacation_days - $vacation_days) + min($working_days, 22) * $rate_per_day;

// Lưu thông tin và điểm hiệu suất vào cơ sở dữ liệu
$sql = "INSERT INTO employees (name, vacation_days_taken, working_days_in_month, rate_per_day)
        VALUES ('$name', $vacation_days, $working_days, $rate_per_day)";

if ($conn->query($sql) === TRUE) {
    echo "Employee information saved successfully.<br>";
    echo "Performance Score for <strong> $name: $performance_score</strong>";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Đóng kết nối
$conn->close();

