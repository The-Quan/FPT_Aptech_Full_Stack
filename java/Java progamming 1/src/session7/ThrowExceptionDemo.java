package session7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowExceptionDemo {
    public static void valueData(){
        try {
            int age = inputAge();
            if (age < 18) {
                throw new ArithmeticException("ban chua du tuoi di lam");
            }else {
                System.out.println("da du tuoi di lam");
            }
           } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
    }
    public static int inputAge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input your age: ");
        int age = sc.nextInt();
        return age;
    }
}
