package luyenTapCode.AppNganHang;

import java.util.Scanner;

public class App {
    public static void menu(){
        System.out.println("hello");
        System.out.println("1. so du ban dau");
        System.out.println("2. nap tien");
        System.out.println("3. rut tien");
        System.out.println("4. chuyen tien");
        System.out.println("5. xem thong tin");
        System.out.println("0. exit");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountBank accountBank = new AccountBank();
        while (true) {
            menu();
            System.out.print("==> lua chon cua ban: ");
            int chose = sc.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("nhap so du ban dau cua ban");
                    accountBank.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.println("nhap so tien nap");
                    accountBank.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("nhap so tien rut");
                    accountBank.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Nhập số tiền chuyển: ");
                    double transferAmount = sc.nextDouble();
                    System.out.println("Nhập số tài khoản đích:");
                    String destinationAccountNumber = sc.next();

                    AccountBank destinationAccount = new AccountBank();
                    destinationAccount.setAccountNumber(destinationAccountNumber);
                    accountBank.transfer(destinationAccount, transferAmount);
                    accountBank.displayAccountInfo();
                    destinationAccount.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("so du tai khoan cua ban: ");
                    break;

                case 0:
                    sc.close();
                    System.exit(0);

                    break;
                default:
                    System.out.println("vui long nhap lai");
            }
        }
    }
}
