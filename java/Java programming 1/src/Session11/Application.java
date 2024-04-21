package Session11;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ValidataAccount validata = new ValidataAccount();
        Controller controller = new Controller();

        boolean isCheck = false;
        while (!isCheck){
            System.out.println("Nhập số điên thoại: ");
            String mobile = sc.nextLine();

            System.out.println("Nhập mật khẩu: ");
            String password = sc.nextLine();

            isCheck = validata.checkAcount(mobile, password);
        }
        while(true){
           menu();
           int choose = sc.nextInt();
           switch (choose){
               case 1:
                   System.out.println("Số dư: ");
                   long balance = controller.getBalanceNumber();
                   System.out.println(Controller.formatMoney(balance));
                   break;
               case 2:
                   controller.actionTransfer();
                   break;
               case 3:
                   System.out.println("Lịch sử giao dịch: ");
                   controller.getHistory();
                   System.out.println();
                   break;
               case 0:
               sc.close();
               System.exit(0);
               break;
               default:
                   System.out.println("Không có lựa chọn này");
                   break;
           }
        }
    }
    public static void menu(){
        System.out.println("lựa chọn của bạn: ");
        System.out.println("1. Xem số dư tài khoản ");
        System.out.println("2. Chuyển khoản");
        System.out.println("3. Xem lịch sử giao dịch");
        System.out.println("0. thoát");
    }
}
