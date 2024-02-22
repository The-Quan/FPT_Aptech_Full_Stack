<?php
// chuối php

echo strlen("Hello world!");  echo "</br>";//Hàm PHP strlen()trả về độ dài của chuỗi.
echo str_word_count("Hello world!"); echo "</br>";//Hàm PHP str_word_count()đếm số từ trong một chuỗi.

echo strpos("Hello world!", "world");echo "</br>";//Hàm PHP strpos() tìm kiếm một văn bản cụ thể trong một chuỗi.

// sửa chuỗi
// Chữ hoa
$x = "Hello World!";
echo strtoupper($x); echo "</br>";//Hàm strtoupper() trả về chuỗi ở dạng chữ hoa

// Chữ thường
$x1 = "Hello World!";
echo strtolower($x1); echo "</br>";//Hàm strtolower() trả về chuỗi ở dạng chữ thường

// Thay thế
$x2 = "Hello World!";
echo str_replace("World", "Dolly", $x2); echo "</br>"; //Hàm PHP str_replace() thay thế một số ký tự bằng một số ký tự khác trong chuỗi.

// Đảo ngược chuỗi
$x3 = "Hello World!";
echo strrev($x3); echo "</br>";//Hàm PHP strrev() đảo ngược một chuỗi.

// Xóa khoảng trắng
$x4 = " Hello World! ";
echo trim($x4); echo "</br>";// Việc trim() xóa mọi khoảng trắng ở đầu hoặc cuối

// Chuyển chuỗi thành mang
$x5 = "Hello World!";
$y = explode(" ", $x5); //Hàm PHP explode()chia một chuỗi thành một mảng.

//Nối chuỗi
$x6 = "Hello";
$y1 = "World";
$z1 = $x6 . $y1;
echo $z1; echo "</br>";//có thể sử dụng '.'  toán tử:
// thêm khoảng trắng
$x7 = "Hello";
$y2 = "World";
$z2 = $x7 . " " . $y2;
echo $z2;echo "</br>";
// cách 2
$x8 = "Hello";
$y3 = "World";
$z3 = "$x8 $y3";
echo $z3;echo "</br>";

// cắt chuỗi
$x9 = "Hello World!";
echo substr($x9, 6); echo "</br>";// cắt đến cuối

$x10 = "Hello World!";
echo substr($x10, -5, 3); echo "</br>";// cắt từ cuối

$x11 = "Hello World!";
echo substr($x11, 5, -3); echo "</br>";// sử dụng độ dài âm dể chỉ định số lượng ký tự cần bỏ qua bắt đầu từ cuối chuỗi

