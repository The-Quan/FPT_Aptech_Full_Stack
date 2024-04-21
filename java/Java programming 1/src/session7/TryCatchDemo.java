package session7;

public class TryCatchDemo {
    public static void tryCatchDemo(){
        int a = 0;
        int b = 20;
        int c = b / a;
        System.out.println(c);
//        try {
//            int c = b / a;
//            System.out.println(c);
//        }catch (Exception e){
//            System.out.println("khong the chia cho 0. " + e.getMessage());
//        }finally {
//            System.out.println("khoi lenh nay luon duoc thuc thi ");
//        }
    }
    public static void trycatchFinallyDemo(){
        /*
        * try catch lồng nhau sử dụng khi tình huống có thể phát sinh trong đó có 1 của khối có thể gay ra lỗi
        * */

        try {
            System.out.println("thuc hien phep chia: ");
            int b = 1000/0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());

        }
        try {
            int a[] = new int[10];
            a[10] = 20;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("kiem soat duoc loi");
        }
        System.out.println("luong chay binh thuong");

    }
    public static void  nestedTryCatchDemo(){

    }
}
