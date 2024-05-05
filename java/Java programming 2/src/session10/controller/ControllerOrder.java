package session10.controller;

import session10.entity.Order;
import session10.model.OrderImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerOrder {
   OrderImpl order = new OrderImpl();

    public void createOrder(Order order1) throws SQLException {
        order.createOrder(order1);
    }
    public void updateOrder(Order order2) throws SQLException {
        order.updateOder(order2);
    }
    public void deleteOrder(Order order3) throws SQLException{
        order.deleteOrder(order3);
    }
    public ArrayList<Order> getAllOrder() throws SQLException {
        ArrayList<Order> orders = order.getAllOrder();
        return orders;
    }
}
