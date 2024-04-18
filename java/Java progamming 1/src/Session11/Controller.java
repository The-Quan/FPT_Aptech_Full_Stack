package Session11;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private static long balanceNumber = 1000000;
    private int transferAmount;

    private int beneficiaryAccount;
    List<Integer> listHistory = new ArrayList<Integer>();


    public long getBalanceNumber(){
        // kiểm tra nếu số tiền nhỏ hơn 50.000 thì không thông báo số tiền chuyển tối thiểu là 50.000
        if (balanceNumber < 50000){
            System.out.println("số tiền chuyển tối thiểu là 50.000");
        }
        //nếu số tiền chuyển lớn hơn số dư thì thông báo tài khoản không đủ
        else if (transferAmount > balanceNumber){
            System.out.println("tài khoản không đủ");
        }
        //nếu chuyên thành công thì thông báo chuyển thành công ỉn ra số dư mới và thêm lịch sử giao dịch mới
        else {
            System.out.println("chuyển tiền thành công");
        }
        return balanceNumber;
    }
    public static long transfer(long money){
        return balanceNumber;
    }
    public void actionTransfer(){
        //thực hiện các công việc như nhập số tài khoản thụ hưởng
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số tài khoản thụ hưởng:");
        this.beneficiaryAccount = sc.nextInt();
        System.out.println("Nhập số tiền muốn chuyển: ");
        this.transferAmount = sc.nextInt();
        if (balanceNumber >= transferAmount){
            balanceNumber -= transferAmount;
            this.listHistory.add((int) balanceNumber);
        }else {
            System.out.println("số du của bạn không đủ");
            System.out.println();
        }
        transfer(transferAmount);
    }
    public long getHistory(){
        //In danh sách lịch sử giao dịch
        for (Integer lichsu : listHistory){
            System.out.println(String.format("số tiền chuyển là: " + transferAmount));
            System.out.println(String.format("số tai khoan thụ hương là: " + beneficiaryAccount));
            System.out.println();
        }
        return 0;
    }

    //định dạng số tiền theo mình mong muốn
    public static String formatMoney(long money){
        DecimalFormat formatter = new DecimalFormat("##,##,##0.00");
        //10000 -> 100,000.00
        return formatter.format(money);
    }
}
