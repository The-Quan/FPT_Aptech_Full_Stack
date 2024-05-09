package session13_Thread.Runnable;

import session13_Thread.Runnable.RunnableDemo;

public class RunnableTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread running...");
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
       // thread.setDaemon(true); // set thread thanh Daemon: thread uu tien thap nhat
        Thread.sleep(1000);
        System.out.println("end Runnable");
    }
}
