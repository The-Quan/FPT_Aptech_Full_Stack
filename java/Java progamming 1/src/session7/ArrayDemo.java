package session7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayDemo {
    public static void createArray(){
        Scanner sc = new Scanner(System.in);
        int size = 0;
        // nếu nhập dữ liệu nhỏ hơn hoặc bằng 0 thì nhập lại
        while (size <= 0){
            boolean check = false;
            while (!check){ // vòng lặp while để lặp khi nhảy vào khối catch
                try {
                    System.out.println("nhap vao so luong cac phan tu mang");
                    size = Integer.parseInt(sc.nextLine());
                    check = true;

                }
                catch (ArithmeticException sql) {
                    System.out.println("Arithmetic");
                }
                catch (OutOfMemoryError io) {
                    System.out.println("ofmen");
                }
                catch (InputMismatchException o) {
                    System.out.println("input data wrong !!!");
                }
                catch (Exception oj){
                    System.out.println("nhap sai, vui long thu lai");
                }
            }
        }
    }
}
