package session10_MVC.model;


import session10_MVC.dao.DBConnection;
import session10_MVC.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private final String SQL_DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
    private final String SQL_GETALL_ORDER = "SELECT * FROM orders";


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
        PreparedStatement pstm = connection.prepareStatement(SQL_DELETE_ORDER);
        pstm.setInt(1,order.getOrder_id());
        pstm.executeUpdate();
    }

    @Override
    public ArrayList<Order> getAllOrder() throws SQLException {
        ArrayList<Order> orders =  new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_GETALL_ORDER);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Order order1 = new Order();
            order1.setOrder_id(rs.getInt(1));
            order1.setCustomerid(rs.getInt(2));
            order1.setDate(rs.getDate(3));
            orders.add(order1);
        }
        rs.close();
        pstm.close();
        return orders;
    }

    public static void main(String[] args) throws SQLException {
       OrderImpl order1 = new OrderImpl();
       order1.getAllOrder();
    }
}
