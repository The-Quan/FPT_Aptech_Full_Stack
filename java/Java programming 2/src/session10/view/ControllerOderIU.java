package session10.view;

import session10.controller.ControllerOrder;
import session10.entity.Order;
import session10.entity.Product;
import session10.model.OrderImpl;

import java.sql.SQLException;
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

}
