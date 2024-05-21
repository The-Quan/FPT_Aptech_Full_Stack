package view;

import controller.AddressBookController;
import entity.AddressBooks;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ViewAddressBooks {
     private final AddressBookController addressBookController = new AddressBookController();
     private final Scanner sc = new Scanner(System.in);

    public void menu(){
        System.out.println("----- Address Book -----");
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
    }
    public void start() throws SQLException {
        while (true){
            menu();
            int choice = sc.nextInt();
            ViewAddressBooks addressBook = new ViewAddressBooks();
            switch (choice){
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.findContactByName();
                    break;
                case 3:
                    addressBook.getAll();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not Valid");
                    break;
            }
        }
    }
    public void addContact() throws SQLException {
        System.out.println("----- Add Contact -----");
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Company: ");
        String company = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Phone: ");
        String phone = sc.nextLine();

        AddressBooks contact = new AddressBooks(name,company,email,phone);
        addressBookController.add(contact);
        System.out.println("Contact added successfully!");
    }
    public void findContactByName() throws SQLException {
        System.out.println("---- find contact by name ------");
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        AddressBooks addressBooks = new AddressBooks();
        addressBooks.setName(name);
        List<AddressBooks> addressBooks1 = addressBookController.search(addressBooks);
        if (addressBooks1.isEmpty()) {
            System.out.println("No contacts found with the name: " + name);
        } else {
            for (AddressBooks contact : addressBooks1) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone: " + contact.getPhone());
            }
        }
    }
    public void  getAll() throws SQLException {
        System.out.println("----- get all -----");
        AddressBooks addressBooks2 = new AddressBooks();
        List<AddressBooks> addressBooks = addressBookController.getAll(addressBooks2);
        for (AddressBooks addressBooks1: addressBooks){
            System.out.println("Name: " + addressBooks1.getName());
            System.out.println("Company: " + addressBooks1.getCompany());
            System.out.println("Email: "+ addressBooks1.getEmail());
            System.out.println("Phone: " + addressBooks1.getPhone());
            System.out.println("---------------------------");
        }
    }
}
