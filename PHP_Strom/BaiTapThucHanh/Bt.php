<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Học PHP</title>
</head>
<body>
<h1>Học PHP</h1>
<?php
//$fullname='Quan';
//echo "xin chao, {$fullname}";
//$a = 10;
//$b = 20;
//echo $a + $b;in

//$is_login = /*true*/ false;
//if($is_login == true){
//    echo "dang nhap thanh cong";
//}else{
//    echo"ko thanh cong";
//}
//
//$n = 3;
//$sum = 0;
//for($i=1; $i<=$n; $i++){
//    if($i % 2 !=0){
//        $sum = $sum +$i;
//    }
////    echo $i. "</br>";
//}
//echo $sum;

//function total($n){
//    $sum = 0;
//    for($i=1; $i<=$n; $i++){
//        if($i % 2 !=0){
//            $sum = $sum +$i;
//        }
////    echo $i. "</br>";
//    }
//    return $sum;
//}
//echo total(30);
?>
<form action="login.php" METHOD="post" >
    name: <br><input type="text" name="name" id="name" ></br>
    password: <br><input type="password" name="password"><br>
    <br><input type="submit" value="dang nhap">
</form>
</body>
</html>

