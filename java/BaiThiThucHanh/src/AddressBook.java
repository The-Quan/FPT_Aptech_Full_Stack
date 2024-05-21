import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void addContact(){
        System.out.println("----- Add Contact -----");
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Company: ");
        String company = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Phone: ");
        String phone = sc.nextLine();

        Contact contact = new Contact(name,company,email,phone);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }
    public void findContactByName(){
        System.out.println("----- Find A Contact By Name");
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Contact contact: contacts){
            if (contact.getName().equalsIgnoreCase(name)){
                System.out.println("Phone: " + contact.getPhone());
                found = true;
            }
            break;
        }
        if (!found){
            System.out.println("Not found");
        }
    }
    public void DisplayContacts(){
        System.out.println("----- Display Contacts -----");
        for (Contact contact: contacts){
            System.out.println("Name: " + contact.getName());
            System.out.println("Company: " + contact.getCompany());
            System.out.println("Email: " + contact.getName());
            System.out.println("Phone: " + contact.getPhone());
            System.out.println("------------------");
        }
    }
}
