package session13_Thread.DaemonThread;

public class NoneDaemonThread extends Thread{
    @Override
    public void run() {
        int i = 1;
        while (i < 10){
            System.out.println("hi from none daemon thread " + i++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("end none daemon thread");
    }
}
