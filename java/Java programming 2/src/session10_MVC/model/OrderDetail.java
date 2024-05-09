package session10_MVC.model;

import session10_MVC.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetail {
    public void createOrder(Order order) throws SQLException;
    public void updateOder(Order order) throws SQLException;
    public void deleteOrder(Order order) throws SQLException;
    public ArrayList<Order> getAllOrder() throws SQLException;
}
