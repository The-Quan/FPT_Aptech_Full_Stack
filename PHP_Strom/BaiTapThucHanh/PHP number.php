<?php
/* Có ba loại số chính trong PHP:
* Integer
* Float
* Number Strings
Ngoài ra, PHP còn có thêm 2 kiểu dữ liệu dùng cho số:
* Infinity
* NaN
*/

$a = 5;
$b = 5.34;
$c = "25";
// xác minh loại bất kỳ của đối tượng nào trong php
var_dump($a); echo "</br>";
var_dump($b); echo  "</br>";
var_dump($c);  echo "</br>";

//kiểm tra xem loại biến có phải là số nguyên ko
$x = 5985;
var_dump(is_int($x));
echo "</br>";
$x = 59.85;
var_dump(is_int($x));

// Kiểm tra xem loại biến có phải là float hay không
echo "</br>";
$x = 10.365;
var_dump(is_float($x));

// Kiểm tra xem một giá trị số là hữu hạn hay vô hạn
echo "</br>";
$x = 1.9e411;
var_dump($x);

//Hàm PHP is_numeric() có thể được sử dụng để tìm xem một biến có phải là số hay không.
// Hàm trả về true nếu biến là số hoặc chuỗi số, ngược lại là false
echo "</br>";
$x2 = 5985;
var_dump(is_numeric($x2));
echo "</br>";
$x = "5985";
var_dump(is_numeric($x));
echo "</br>";
$x = "59.85" + 100;
var_dump(is_numeric($x));
echo "</br>";
$x = "Hello";
var_dump(is_numeric($x));

//Các hàm (int), (integer), và intval() thường được sử dụng để chuyển
// đổi một giá trị thành số nguyên.

// Cast float to int
$x = 23465.768;
$int_cast = (int)$x;
echo $int_cast;

echo "<br>";

// Cast string to int
$x = "23465.768";
$int_cast = (int)$x;
echo $int_cast;