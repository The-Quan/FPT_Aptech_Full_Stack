package BaiThiThucHanh;

public class AccountBank {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBank() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0.0;
    }

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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Gửi tiền thành công.");
        } else {
            System.out.println("Số tiền gửi không hợp lệ.");
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <=balance){
            balance -= amount;
            System.out.println("rút tiền thành công");

        }else {
            System.out.println("số dư không đủ hoặc số tiền rút không hợp lệ");
        }
    }

    public void transfer(AccountBank recipientAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipientAccount.deposit(amount);
            System.out.println("Chuyển thành công.");
        } else {
            System.out.println("Số dư không đủ để chuyển khoản.");
        }
    }
}
