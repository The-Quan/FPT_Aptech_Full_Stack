package session10_MVC.model;

import session10_MVC.dao.DBConnection;
import session10_MVC.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerIplm implements CustomerDao{
    public static Connection connection;
    static {
        try {
            connection = DBConnection.DataBase();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private final String SQL_CREATE_CUSTOMER = "INSERT INTO customers values(?,?,?,?)";
    private final String SQL_UPDATA_CUSTOMER = "UPDATE customers SET first_name = ?  WHERE customer_id = ?";
    private final String SQL_DELETE_CUSTOMER = "DELETE FROM customers WHERE customer_id = ?";
    private final String SQL_ALLCUSTOMER = "SELECT * FROM customers";
    @Override
    public void createCustomer(Customer customer) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_CREATE_CUSTOMER);
        pstm.setInt(1,customer.getCustomerId());
        pstm.setString(2,customer.getFirstName());
        pstm.setString(3,customer.getLastName());
        pstm.setString(4,customer.getEmail());
        pstm.executeUpdate();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_UPDATA_CUSTOMER);
        pstm.setString(1,customer.getFirstName());
        pstm.setInt(2,customer.getCustomerId());
        pstm.executeUpdate();
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SQL_DELETE_CUSTOMER);
        pstm.setInt(1,customer.getCustomerId());
        pstm.executeUpdate();
    }

    @Override
    public ArrayList<Customer> allCustomer() throws SQLException {
        ArrayList<Customer> allCustomer = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SQL_ALLCUSTOMER);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setEmail(rs.getString(4));
            allCustomer.add(customer);
        }
        rs.close();
        pstm.close();
        return allCustomer;
    }
}
