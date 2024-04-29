package session10.model;

import session10.entity.Order;

import java.sql.SQLException;

public interface OrderDetail {
    public void createOrder(Order order) throws SQLException;
    public void updateOder(Order order) throws SQLException;
    public void deleteOrder(Order order) throws SQLException;
    public void getAllOrder(Order order) throws SQLException;
}
