package StoreBook_2025.view;

import StoreBook_2025.controller.LoginController;
import StoreBook_2025.entity.Login;
import StoreBook_2025.model.LoginMD;

import java.sql.SQLException;
import java.util.Scanner;

public class ViewLogin {
    public void loginView() throws SQLException {
        System.out.println("------------ login ------------");
        System.out.println("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        Login login = new Login(username, password);
        LoginController loginController = new LoginController();
        loginController.Login(login);
    }

    public static void main(String[] args) {
        ViewLogin viewLogin = new ViewLogin();
        try {
            viewLogin.loginView();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
