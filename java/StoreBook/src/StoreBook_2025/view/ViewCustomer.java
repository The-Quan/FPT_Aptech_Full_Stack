package StoreBook_2025.view;

import StoreBook_2025.controller.StoreBookController;
import StoreBook_2025.entity.Customers;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewCustomer {
    StoreBookController<Customers> controller = new StoreBookController<>();

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Add Customer -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        Customers customer = new Customers(id, name, email, phone);

        controller.add(customer);
        System.out.println("add success");
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Add Customer -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        Customers customer = new Customers();
        customer.setCustomerId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        controller.update(customer);
        System.out.println("update success");
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Delete Customer -----");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Customers customer = new Customers();
        customer.setCustomerId(id);
        controller.delete(customer);
        System.out.println("delete success");
    }

    public void search() throws SQLException {
        System.out.println("----- search -----");
        System.out.print("Enter ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();

        Customers customers = new Customers();
        customers.setCustomerId(id);
        StoreBookController<Customers> searchController = new StoreBookController<>();
        List<Customers> search = searchController.search(customers);
        for (Customers customers1 : search) {
            System.out.println("Customer ID: " + customers1.getCustomerId());
            System.out.println("Name: " + customers1.getName());
            System.out.println("Email: " + customers1.getEmail());
            System.out.println("Phone: " + customers1.getPhone());
        }
    }

    public void getAll() throws SQLException {
        Customers customers = new Customers();
        StoreBookController<Customers> customersStoreBookController = new StoreBookController<>();
        List<Customers> allCustomers = customersStoreBookController.getAll(customers);
        for (Customers customer : allCustomers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println("-----------------");
        }
    }

}
