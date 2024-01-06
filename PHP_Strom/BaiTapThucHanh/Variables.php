<?php
// variable (biến)
$x = 5;
$y =" Quan";
$z = 4;
echo $x;
echo "</br>";
echo $y;
echo "</br>";
// xuất ra văn bản và một biến
$txt = "Fpt aptech";
echo "I love $txt";
// xuất ra vd tương tự vd trên
echo "</br>";
echo "I love ". $txt. "!";
// xuất ra tổng của hai biến
echo "</br>";
echo $x + $z;
//php ko có lệnh khai báo biến và kiểu dữ liệu phụ thuộc vào giá trị của biến
echo $x;  // $x là một kiểu số nguyên
echo $y; // $y là một  chuỗi

// get the type (lấy các kiểu)
echo "</br>";
var_dump($x); // hàm var_dump() trả về kiểu dữ liệu và giá trị
echo "</br>";
var_dump(5);echo "</br>";
var_dump("John");echo "</br>";
var_dump(3.14);echo "</br>";
var_dump(true);echo "</br>";
var_dump([2, 3, 56]);echo "</br>";
var_dump(NULL);

// gán một giá trị
echo "</br>";
echo $x;

// gán nhiều giá trị
$x = $y = $z = "Quân";
echo $x;
echo $y;
echo $z;

?>

