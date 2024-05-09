package session13_Thread.DaemonThread;

public class DeamonTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread running ... \n");
        // tao mot thread
        Thread deamonThread = new DeamonThreadDemo();
        // set no la daemon thread
        deamonThread.setDaemon(true);
        deamonThread.start();

        new NoneDaemonThread().start();
        Thread.sleep(5000);

        System.out.println("Main thread stop");
    }
}
