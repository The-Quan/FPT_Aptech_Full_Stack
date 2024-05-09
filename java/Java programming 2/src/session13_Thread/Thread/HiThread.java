package session13_Thread.Thread;

public class HiThread extends Thread{
    // viết code trong hàm run sẽ được thực thi khi:
    // thread nay chay (start)
    @Override
    public void run() {
        int index = 1;
        for (int i = 0; i < 5; i ++){
            System.out.println("HiThread runningHi....." + index ++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("=> end thread");
    }
}
