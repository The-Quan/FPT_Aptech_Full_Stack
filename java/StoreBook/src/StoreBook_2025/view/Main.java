package StoreBook_2025.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu(){
        System.out.println("----- Menu -----");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("4. Order Detail");
        System.out.println("0. Exit");
        System.out.print("=> Enter: ");
    }
    public void menuCustomer(){
        System.out.println("----- Menu Customer-----");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Get ALl");
        System.out.println("0. Exit");
        System.out.print("=> Enter: ");
    }
    public void menuProduct(){
        System.out.println("----- Menu Product-----");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Search");
        System.out.println("5. Get ALl");
        System.out.println("0. Exit");
        System.out.print("=> Enter: ");
    }
    public void menuOrder(){
        System.out.println("----- Order  -----");
        System.out.println("1. add order ");
        System.out.println("2. show order ");
        System.out.println("0. exit");
        System.out.print("=> Enter: ");
    }
    public void menuOrderDetail(){
        System.out.println("----- Order Detail -----");
        System.out.println("1. add order Detail");
        System.out.println("2. show order Detail");
        System.out.println("0. exit");
        System.out.print("=> Enter: ");
    }
    public void start() throws SQLException, IllegalAccessException {
        while (true){
            menu();
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i){
                case 1:
                    menuCustomer();
                    int i2 = sc.nextInt();
                    ViewCustomer viewCustomer =  new ViewCustomer();
                    switch (i2){
                        case 1:
                            viewCustomer.add();
                            break;
                        case 2:
                            viewCustomer.update();
                            break;
                        case 3:
                            viewCustomer.delete();
                            break;
                        case 4:
                            viewCustomer.search();
                            break;
                        case 5:
                            viewCustomer.getAll();
                            break;
                        case 0:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("vui long nhap lai");
                            break;
                    }
                    break;
                case 2:
                      menuProduct();
                      int i3 = sc.nextInt();
                      ViewProduct viewProduct = new ViewProduct();
                      switch (i3){
                          case 1:
                              viewProduct.add();
                              break;
                          case 2:
                              viewProduct.update();
                              break;
                          case 3:
                              viewProduct.delete();
                              break;
                          case 4:
                              viewProduct.search();
                              break;
                          case 5:
                              viewProduct.getAll();
                              break;
                          case 0:
                              System.exit(0);
                              break;
                          default:
                              System.out.println("vui long nhap lai");
                              break;
                      }
                      break;
                case 3:
                    menuOrder();
                    int i5 = sc.nextInt();
                    ViewOrder viewOrder = new ViewOrder();
                    switch (i5){
                        case 1:
                            viewOrder.order();
                            break;
                        case 2:
                            viewOrder.showOrder();
                            break;
                    }
                    break;
                case 4:
                    menuOrderDetail();
                    ViewOrderDetail viewOrderDetail = new ViewOrderDetail();
                    int i4 = sc.nextInt();
                    switch (i4){
                        case 1:
                            viewOrderDetail.addOrderdetail();
                            break;
                        case 2:
                            viewOrderDetail.showOrderDetail();
                            break;
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long nhap lai");
            }
        }
    }
}
