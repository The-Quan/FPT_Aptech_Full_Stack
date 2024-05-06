package Slot_4.BaiTapCuaHang.view;

import Slot_4.BaiTapCuaHang.controller.ControllerStore;
import Slot_4.BaiTapCuaHang.entity.Product;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ViewStore {
    final Scanner sc;

    public ViewStore() {
        this.sc = new Scanner(System.in);
    }
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
        Product product = new Product();
        product.setProduct_id(id);
        controllerStore.deleteProduct(product);
        System.out.println("=> thanh cong");
    }
    public void searchProduct() throws SQLException {
        System.out.println("----- Search Product -----");
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Product product1 = new Product();
        product1.setProduct_id(id);
        controllerStore.searchProduct(product1);
        System.out.println("Product ID: "+product1.getProduct_id());
        System.out.println("Product Name: "+product1.getProduct_name());
        System.out.println("Price: "+product1.getPrice());
        System.out.println("Status: "+product1.isStatus());
    }
    public void allProduct() throws SQLException {
        System.out.println("----- All Product -----");
        Product product2 = new Product();
        List<Product> products = controllerStore.allProduct(product2);

        for (Product product : products){
            System.out.println("Product ID: "+product.getProduct_id());
            System.out.println("Product Name: "+product.getProduct_name());
            System.out.println("Price: "+product.getPrice());
            System.out.println("Status: "+product.isStatus());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) throws SQLException {
        ViewStore viewStore = new ViewStore();
        viewStore.allProduct();
    }
}
