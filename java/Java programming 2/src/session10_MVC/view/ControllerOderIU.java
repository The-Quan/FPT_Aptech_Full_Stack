package session10_MVC.view;

import session10_MVC.controller.ControllerOrder;
import session10_MVC.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ControllerOderIU {
    ControllerOrder controllerOrder = new ControllerOrder();
    final Scanner sc;

    public ControllerOderIU() {
        this.sc = new Scanner(System.in);
    }


    public void createOrder() throws SQLException {
        System.out.println("vui long nhap thong tin");
        System.out.println("nhap order ID: ");
        int orderId = sc.nextInt();
        sc.nextLine();
        System.out.println("nhap customer ID: ");
        int customorID = sc.nextInt();

        Order orders = new Order(orderId,customorID,new Date());
        controllerOrder.createOrder(orders);
    }
    public void updateOder() throws SQLException {
        System.out.println("nhap id: ");
        int Id = sc.nextInt();
        sc.nextLine();
        System.out.println("sua customer Id: ");
        int ID2 = sc.nextInt();
        sc.nextLine();

        Order order = new Order();
        order.setOrder_id(Id);
        order.setCustomerid(ID2);
        controllerOrder.updateOrder(order);
        System.out.println("name da duoc doi thanh " + order.getCustomerid());
    }
    public void deleteOrder() throws SQLException {
        System.out.println("Nhap ID: ");
        int id = sc.nextInt();
        Order order = new Order();
        order.setOrder_id(id);
        controllerOrder.deleteOrder(order);
        System.out.println("da xoa orser co ID = " + order.getOrder_id());

    }
    public void getAllOrder() throws SQLException {
        ControllerOrder controllerOrder = new ControllerOrder();
        ArrayList<Order> allOrder = controllerOrder.getAllOrder();
        for (Order order : allOrder) {
            System.out.println("order ID: " + order.getOrder_id());
            System.out.println("customer ID: " + order.getCustomerid());
            System.out.println("date:  " + order.getDate());
            System.out.println("--------------------------------------");
        }
    }
}
