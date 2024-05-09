package onTapCode.Thread;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(50);
        Producer p1 = new Producer(1,buffer);
        Customer c1 = new Customer(1,buffer);

        // bat dau mau hang
        p1.start();
        // bat dau san xuat
        c1.start();
        System.out.println("okk");
    }
}
