import java.util.Scanner;

public class Application {
    public void menu(){
        System.out.println("----- Address Book -----");
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
    }
    private static final Scanner sc = new Scanner(System.in);
    public void start(){
        while (true){
            menu();
            int choice = sc.nextInt();
            AddressBook addressBook = new AddressBook();
            switch (choice){
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.findContactByName();
                    break;
                case 3:
                    addressBook.DisplayContacts();
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
    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}