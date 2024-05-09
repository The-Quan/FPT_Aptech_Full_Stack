package session10_MVC.model;

import session10_MVC.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao {
    public void createCustomer(Customer customer) throws SQLException;
    public void updateCustomer(Customer customer) throws SQLException;
    public void deleteCustomer(Customer customer) throws SQLException;
    public ArrayList<Customer> allCustomer() throws SQLException;
}
