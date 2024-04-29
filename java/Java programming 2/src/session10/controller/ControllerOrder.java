package session10.controller;

import session10.entity.Order;
import session10.model.OrderImpl;

import java.sql.SQLException;

public class ControllerOrder {
   OrderImpl order = new OrderImpl();

    public void createOrder(Order order1) throws SQLException {
        order.createOrder(order1);
    }
    public void updateOrder(Order order2) throws SQLException {
        order.updateOder(order2);
    }
}
