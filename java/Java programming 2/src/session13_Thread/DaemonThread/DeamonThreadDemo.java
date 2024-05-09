package session13_Thread.DaemonThread;

public class DeamonThreadDemo extends Thread {
    @Override
    public void run() {
        int count = 0;
        while (true){
            System.out.println("Deamon thread " + count ++);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
