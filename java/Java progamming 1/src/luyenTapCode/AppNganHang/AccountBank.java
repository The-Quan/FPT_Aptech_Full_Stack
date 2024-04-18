package luyenTapCode.AppNganHang;

public class AccountBank {
    private String accountBank;
    private String accountNumber;
    private double balance;

    public AccountBank(){
        this.accountBank = "";
        this.accountNumber = "";
        this.balance = 0.0;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void displayAccountInfo(){
        System.out.println("in ra so tai khoan: " + accountNumber);
        System.out.println("in ra ten chu tai khoan: " + accountBank);
        System.out.println("in ra so du: " + balance);
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("so du hien tai la: " + balance);
        }else{
            System.out.println("vui long thu lai");
        }
    }
    public void withdraw(double amount){
        if (amount > 0){
            balance -= amount;
            System.out.println("so du hien tai la: " + balance);
        }else{
            System.out.println("vui long thu lai");
        }
    }
    public void transfer(AccountBank recipientAccount, double amount){
        if(balance >= amount){
            balance -= amount;
            recipientAccount.deposit(amount);
            System.out.println("chuyen tien thanh cong");
        }else{
            System.out.println("vui long thu lai");
        }
    }
}
