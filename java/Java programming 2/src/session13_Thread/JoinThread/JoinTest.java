package session13_Thread.JoinThread;

public class JoinTest {
    public static void main(String[] args) {
        System.out.println("\n main thread starting...");
        Thread joinThread = new JoinThreadDemo("ABC",2);
        Thread joinThread1 = new JoinThreadDemo("ABC1",3);
        Thread joinThread2 = new JoinThreadDemo("ABC2",4);

        // thread ko dung join
        Thread noJoinThread3 = new JoinThreadDemo("ABC3",5);

        joinThread.start();
        joinThread1.start();
        joinThread2.start();
        noJoinThread3.start();
        
        // su dung joim
        joinThread.start();
        joinThread1.start();
        joinThread2.start();


        // doan code duoi day se phai cho cho toi khi 2 threadA,B hoan thanh moi chay tiep
        System.out.println("hi from main thread.....");
        System.out.println(joinThread.isAlive());
        System.out.println(joinThread1.isAlive());
        System.out.println(joinThread2.isAlive());
    }
}
