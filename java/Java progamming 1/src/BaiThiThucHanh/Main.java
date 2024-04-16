package bank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create a new AccountBank object
            AccountBank account = new AccountBank();

            // Input account information
            System.out.println("Enter account number:");
            account.setAccountNumber(scanner.next());
            System.out.println("Enter account holder name:");
            account.setAccountHolderName(scanner.next());
            System.out.println("Enter initial balance:");
            account.deposit(scanner.nextDouble());

            // Test transactions
            account.displayAccountInfo();

            System.out.println("Enter deposit amount:");
            account.deposit(scanner.nextDouble());
            account.displayAccountInfo();

            System.out.println("Enter withdrawal amount:");
            account.withdraw(scanner.nextDouble());
            account.displayAccountInfo();

            System.out.println("Enter transfer amount:");
            double transferAmount = scanner.nextDouble();
            System.out.println("Enter destination account number:");
            String destinationAccountNumber = scanner.next();
            AccountBank destinationAccount = new AccountBank();
            destinationAccount.setAccountNumber(destinationAccountNumber);
            account.transfer(destinationAccount, transferAmount);
            account.displayAccountInfo();
            destinationAccount.displayAccountInfo();

            scanner.close();
        }

}