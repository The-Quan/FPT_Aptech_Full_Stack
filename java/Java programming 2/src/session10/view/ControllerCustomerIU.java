package session10.view;

import session10.controller.ControllerCustomer;
import session10.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerCustomerIU {
    ControllerCustomer controllerCustomer = new ControllerCustomer();
    final Scanner sc;
    public ControllerCustomerIU() {
        this.sc = new Scanner(System.in);
    }
    public void createCustomer() throws SQLException {
        System.out.println("vui long nhap thong tin");
        System.out.println("Customer ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("First Name:");
        String fname = sc.nextLine();
        System.out.println("Last Name:");
        String lname = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        Customer customer = new Customer(id,fname,lname,email);
        controllerCustomer.createCustomer(customer);
    }
    public void updateCustomer() throws SQLException {
        System.out.println("Customer ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Sua ten thanh:");
        String name = sc.nextLine();
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(name);
        controllerCustomer.updateCustomer(customer);
    }
    public void deleteCustomer() throws SQLException {
        System.out.println("Customer Id:");
        int id = sc.nextInt();
        Customer customer = new Customer();
        customer.setCustomerId(id);
        controllerCustomer.deleteCustomer(customer);
    }
    public void allCustomer() throws SQLException {
        ControllerCustomer customer = new ControllerCustomer();
        ArrayList<Customer> getAllCutomer = customer.getAllCustomer();
        for (Customer all : getAllCutomer){
            System.out.println("======= Customer =========");
            System.out.println("customer id: "+all.getCustomerId());
            System.out.println("first name: "+all.getFirstName());
            System.out.println("last name:  "+all.getLastName());
            System.out.println("customer id: "+all.getEmail());
            System.out.println();
        }
    }

}
