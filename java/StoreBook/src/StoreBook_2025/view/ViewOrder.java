package StoreBook_2025.view;

import StoreBook_2025.controller.StoreBookController;
import StoreBook_2025.entity.Orders;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewOrder {
    Scanner sc = new Scanner(System.in);

    public void order() throws SQLException {
        System.out.println("----- Order ------");
        System.out.print("Enter Customer Id: ");
        int cusid = sc.nextInt();
        System.out.print("Enter Product Id: ");
        int proid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        Date date = new Date();

        Orders orders = new Orders();
        orders.setCustomer_id(cusid);
        orders.setProduct_id(proid);
        orders.setAddress(address);
        orders.setQuantity(quantity);
        orders.setDate(date);
        StoreBookController<Orders> ordersStoreBookController = new StoreBookController<>();
        ordersStoreBookController.order(orders);
        System.out.println("Order Success");
    }
    public void showOrder(){
        System.out.println("----- Show Order -----");
        Orders orders = new Orders();
        StoreBookController storeBookController = new StoreBookController();
        List<Orders> getAllOrder = storeBookController.showOrder(orders);
        for (Orders orders1: getAllOrder){
            System.out.println("Order ID: " + orders1.getOrder_id());
            System.out.println("Customer ID: " + orders1.getCustomer_id());
            System.out.println("Product ID: " + orders1.getProduct_id());
            System.out.println("Address: " + orders1.getAddress());
            System.out.println("Quantity: " + orders1.getQuantity());
            System.out.println("Date: " + orders1.getDate());
            System.out.println("------------------");
        }
    }

    public static void main(String[] args) throws SQLException {
//        ViewOrder viewOrder = new ViewOrder();
//        viewOrder.order();

    }
}
