package StoreBook_2025.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu(){
        System.out.println("----- Menu -----");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Oder");
        System.out.println("4. Oder Detail");
        System.out.println("0. Exit");
        System.out.print("=> Enter: ");
    }
    public void menuCustomer(){
        System.out.println("----- Menu Customer-----");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get ALl");
        System.out.println("0. Exit");
    }
    public void start() throws SQLException {
        ViewLogin viewLogin = new ViewLogin();
        viewLogin.loginView();
        while (true){
            menu();
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i){
                case 1:
                    menuCustomer();
                    int i2 = sc.nextInt();
                    switch (i2){
                        case 1:
                            ViewCustomer viewCustomer =  new ViewCustomer();
                            viewCustomer.add();
                            break;
                        case 0:
                            System.exit(0);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
