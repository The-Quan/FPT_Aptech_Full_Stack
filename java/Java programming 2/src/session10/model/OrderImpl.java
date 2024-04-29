package session10.model;


import session10.dao.DBConnection;
import session10.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class OrderImpl implements OrderDetail{
    public static Connection connection;
    static {
        try {
            connection = DBConnection.DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private final String SQL_CREATE_ORDER =  "insert into orders values (?, ?, ?)";
    private final String SQL_UPDATE_ORDER = "UPDATE orders set customerid = ? where order_id = ?";


    @Override
    public void createOrder(Order order) throws SQLException {
        java.util.Date utilDate = order.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        PreparedStatement pstm = connection.prepareStatement(SQL_CREATE_ORDER);
        pstm.setInt(1,order.getOrder_id());
        pstm.setInt(2,order.getCustomerid());
        pstm.setDate(3,sqlDate);
        pstm.executeUpdate();
    }

    @Override
    public void updateOder(Order order) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATE_ORDER);
        pstm.setInt(1,order.getCustomerid());
        pstm.setInt(2,order.getOrder_id());
        pstm.executeUpdate();
    }

    @Override
    public void deleteOrder(Order order) throws SQLException {

    }

    @Override
    public void getAllOrder(Order order) throws SQLException {

    }

    public static void main(String[] args) throws SQLException {
       Order order = new Order();
       order.setOrder_id(13);
       order.setCustomerid(6);
       OrderImpl order1 = new OrderImpl();
       order1.updateOder(order);
    }
}
