package session13_Thread.Thread;

import session13_Thread.Thread.HiThread;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        int idx = 1;
        for (int i = 0; i < 5; i++){
            System.out.println("Main thread running1....." + idx ++ );
            Thread.sleep(2000);
        }
        HiThread hiThread = new HiThread();
        //Chay Thread
        hiThread.start();

        for (int i = 1; i < 5; i++){
            System.out.println("Main thread running2...... " + idx);
            // ngủ
            Thread.sleep(2000);
        }
        System.out.println("=> Main thread stopped");
    }
}
