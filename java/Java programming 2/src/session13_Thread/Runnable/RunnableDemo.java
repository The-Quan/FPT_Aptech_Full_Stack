package session13_Thread.Runnable;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        int index = 1;
        for (int i = 0; i < 5; i++){
            System.out.println("Hi from Runnable " + index ++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}