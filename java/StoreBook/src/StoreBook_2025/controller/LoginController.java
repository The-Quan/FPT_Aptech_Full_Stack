package StoreBook_2025.controller;

import StoreBook_2025.entity.Login;
import StoreBook_2025.model.LoginMD;

import java.sql.SQLException;

public class LoginController {
    LoginMD loginMD = new LoginMD();
    public void Login(Login login) throws SQLException {
        loginMD.LoginStore(login);
    }
}
