package Slot_4.BaiTapCuaHang.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void menu(){
        System.out.println("----- menu -----");
        System.out.println("1. Add Product");
        System.out.println("2. Search Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Show All Products");
        System.out.println("5.Show products that are out of stock");
        System.out.println("0. Exit");
        System.out.print("Lua chon cua ban: ");
    }
    public void start() throws SQLException {
        while(true){
            menu();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            ViewStore viewStore = new ViewStore();
            switch (choice){
                case 1:
                     viewStore.addProduct();
                     break;
                case 2:
                    viewStore.searchProduct();
                    break;
                case 3:
                    viewStore.deleteProduct();
                    break;
                case 4:
                    viewStore.allProduct();
                    break;
                case 5:
                    viewStore.showAllProductHet();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long nhap lai");
                    break;
            }

        }
    }
}
