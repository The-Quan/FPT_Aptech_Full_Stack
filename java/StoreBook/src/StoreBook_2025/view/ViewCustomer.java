package StoreBook_2025.view;

import StoreBook_2025.entity.Customers;

import java.util.Scanner;

public class ViewCustomer {
public void add(){
    Scanner sc = new Scanner(System.in);
    System.out.println("----- Add Product -----");
    System.out.print("ID: ");
    int id = Integer.parseInt(sc.nextLine());
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Phone: ");
    String phone = sc.nextLine();
    Customers customer = new Customers(id,name,email,phone);
}
}
