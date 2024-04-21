package btLyThuyet.asbtract;
// tính trừu tượng
public class index2 extends index{
    void run(){
        System.out.println("running safely ...");
    }
// index 2 truyền phương thức vào run thông qua main.run
    public static void main(String[] args) {
        index main = new index2();
        main.run();
    }
}
