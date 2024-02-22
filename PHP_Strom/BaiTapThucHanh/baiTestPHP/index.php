
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>insert php</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-6 offset-md-3">
            <form id="from_reg" class="bg-light p-4 my-3" action="reg.php" method="POST">
                <h2 class="py-3 text-center text-uppercase">Đăng kí tài khoản</h2>
                <div class="form-group">
                    <lable for="fullname">họ và tên</lable>
                    <input type="text" name="fullname" class="form-control" id="fullname">
                </div>
                <div class="form-group">
                    <lable for="fullname">tên đang nhập</lable>
                    <input type="text" name="username" class="form-control" id="username">
                </div>
                <div class="form-group">
                    <lable for="fullname">mật khẩu</lable>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                <div class="form-group">
                    <lable for="fullname">email</lable>
                    <input type="email" name="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <lable for="">giới tính</lable>
                    <div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                            <lable class="form_check">Nam</lable>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" id="male" value="female">
                            <lable class="form_check">nữ</lable>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <lable for="address">địa chỉ</lable>
                    <input type="text" name="address" class="form-control" id="address">
                </div>
                <input type="submit" class="btn btn-primary btn-bloock mt-4" name="btn-reg" value="đăng kí">
            </form>
        </div>
    </div>
</div>
</body>
</html>