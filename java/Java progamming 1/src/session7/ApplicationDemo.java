//package session7;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class ApplicationDemo {
//    public static void main(String[] args) {
//        TryCatchDemo.tryCatchDemo();
//        ThrowExceptionDemo.valueData();
//        try{
//            int age = intoutAge();
//            System.out.println("tuoi vua nhap: " + age);
//
//        }catch (AgeChecking e){
//            System.out.println(e.getMessage());
//        }
//    }
//    static int intoutAge() throws AgeChecking{
//        Scanner sc = new Scanner(System.in);
//        System.out.println("nhap do tuoi cua nhan vien");
//        int age = 0;
//        try{
//            age = sc.nextInt();
//            if (age < 0 ) throw new AgeChecking("tuoi ko dc < 0");
//        }catch (InputMismatchException e ){
//            throw new AgeChecking("tuoi phai la number");
//        }
//    }
//}
