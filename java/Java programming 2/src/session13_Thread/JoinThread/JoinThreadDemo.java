package session13_Thread.JoinThread;


// thread.join(); <=> join(0)
// thông báo rằng hay cho thread hoàn thành rồi thread cha mới chạy tiếp tục
// chạy tiếp. Thread cha con phải đợi cho tới khi thread kết thúc mới chạy
public class JoinThreadDemo extends Thread{
    private String threadName;
    private int count;
    public JoinThreadDemo(String threadName, int count){
        this.threadName = threadName;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i<count; i++){
            System.out.println("hi from: " + this.threadName + " " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\n thread " + threadName + "end");
    }
}
