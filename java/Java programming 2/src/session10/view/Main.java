package session10.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu(){
        System.out.println("===== Menu =====");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("0. exit");
    }
    public void menuProduct(){
        System.out.println("===== Menu product =====");
        System.out.println("1. create product");
        System.out.println("2. update product");
        System.out.println("3. delete product");
        System.out.println("4. getAll product");
        System.out.println("0. exet");
    }
    public void menuOrder(){
        System.out.println("===== Menu order =====");
        System.out.println("1. create order");
        System.out.println("2. update order");
        System.out.println("3. delete order");
        System.out.println("4. getAll order");
        System.out.println("0. exet");
    }
    public void start() throws SQLException {
        while (true){
            menu();
            System.out.print("lua chon cua ban: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 2:
                    menuProduct();
                    System.out.print("lua chon cua ban: ");
                    int choice1 = sc.nextInt();
                    System.out.println();
                    ControllerProductIu controllerProductIu = new ControllerProductIu();
                    switch (choice1){
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            controllerProductIu.createProductIu();
                            break;
                        case 2:
                            controllerProductIu.updateProductIu();
                            break;
                        case 3:
                            controllerProductIu.deleteProductIu();
                            break;
                        case 4:
                            controllerProductIu.getAllProductIu();
                            break;
                    }
                    break;
                case 3:
                    menuOrder();
                    System.out.println();
                    System.out.print("lua chon cua ban: ");
                    int choice2 = sc.nextInt();
                    System.out.println();
                    ControllerOderIU controllerOderIU = new ControllerOderIU();
                    switch (choice2){
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            controllerOderIU.createOrder();
                            break;
                        case 2:
                            controllerOderIU.updateOder();
                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                    }
            }
        }
    }
}
