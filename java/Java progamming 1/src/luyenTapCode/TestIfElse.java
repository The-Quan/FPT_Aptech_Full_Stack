package luyenTapCode;

import java.util.Scanner;

public class TestIfElse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("vui long nhap du lieu: ");
        int thang = sc.nextInt();
        System.out.println("ket qua");
        if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 9 || thang == 11){
            System.out.println("thang co 31 ngay");
        } else if (thang == 2) {
            System.out.println("thang co 28 ngay");
        } else{
            System.out.println("thang co 30 ngay");
        }
    }
}
