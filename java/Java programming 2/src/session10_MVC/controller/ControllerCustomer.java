package session10_MVC.controller;

import session10_MVC.entity.Customer;
import session10_MVC.model.CustomerIplm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerCustomer {
    CustomerIplm customerIplm = new CustomerIplm();
    public void createCustomer(Customer customer) throws SQLException {
        customerIplm.createCustomer(customer);
    }
    public void updateCustomer(Customer customer) throws SQLException {
        customerIplm.updateCustomer(customer);
    }
    public void deleteCustomer(Customer customer) throws SQLException {
        customerIplm.deleteCustomer(customer);
    }
    public ArrayList<Customer> getAllCustomer() throws SQLException {
        ArrayList<Customer> allctm = customerIplm.allCustomer();
        return allctm;
    }
}
