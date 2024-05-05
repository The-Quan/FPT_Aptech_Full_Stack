package Slot_4.BaiTapCuaHang.view;

import Slot_4.BaiTapCuaHang.controller.ControllerStore;
import Slot_4.BaiTapCuaHang.entity.Product;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ViewStore {
    final Scanner sc;

    public ViewStore() {
        this.sc = new Scanner(System.in);
    }
    Product product = new Product();
    ControllerStore controllerStore = new ControllerStore();

    public void addProduct() throws SQLException {
        System.out.println("----- Add Product -----");
        System.out.print("Product ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Product Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        Double price = Double.parseDouble(sc.nextLine());
        System.out.print("Status: ");
        Boolean status = Boolean.parseBoolean(sc.nextLine());

        Product product = new Product(id,name,price,status);
        controllerStore.addProduct(product);
        System.out.println("=> thanh cong");
    }
    public void deleteProduct() throws SQLException {
        System.out.println("----- Delete Product -----");
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        product.setProduct_id(id);
        controllerStore.deleteProduct(product);
        System.out.println("=> thanh cong");
    }
    public void searchProduct() throws SQLException {
        System.out.println("----- Search Product -----");
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());;
         
        System.out.println(product.getProduct_id());
        System.out.println(product.getProduct_name());
        System.out.println(product.getPrice());
        System.out.println(product.isStatus());
        controllerStore.searchProduct(product);
    }

    public static void main(String[] args) throws SQLException {
        ViewStore viewStore = new ViewStore();
        viewStore.searchProduct();
    }
}
