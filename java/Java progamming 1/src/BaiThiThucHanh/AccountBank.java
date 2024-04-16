package BaiThiThucHanh;

public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor with default values
    public AccountBank() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0.0;
    }

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " successfully.");
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Transfer method
    public void transfer(AccountBank destinationAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to account " + destinationAccount.getAccountNumber() + " successfully.");
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
}
