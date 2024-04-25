package statementss8.view;

import statementss8.controller.LoginController;
import statementss8.entity.Users;

import java.io.IOException;
import java.util.Scanner;

public class LoginConsoleUI {
    LoginController loginController = new LoginController();

    Users users = new Users();

    private final Scanner sc;

    public LoginConsoleUI() throws IOException{
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("====Adim zone=====");
        System.out.println("1. login statement");
        System.out.println("2. login preparedStatement");
        System.out.println("0. exit ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    private void loginStatement(){
        System.out.println("nhap ten cua ban: ");
        String username = sc.nextLine();
        System.out.println("nhap password");
        String password = sc.nextLine();
        users.setUsername(username);
        users.setPassword(password);

        String result = loginController.loginStatementController(users);
        System.out.println(result);
    }
    private void loginPreparedStament(){
        System.out.println("nhap ten cua ban: ");
        String username = sc.nextLine();
        System.out.println("nhap password");
        String password = sc.nextLine();
        users.setUsername(username);
        users.setPassword(password);

        String result = loginController.loginPreparedController(users);
        System.out.println(result);
    }
    public void start(){
        while (true){
            int choice = menu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    loginStatement();
                    break;
                case 2:
                    loginPreparedStament();
                    break;
                default:
                    throw  new AssertionError();
            }
        }
    }
}
