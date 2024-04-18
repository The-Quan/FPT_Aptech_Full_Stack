package Session11.t2308a;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id = 0L;
    private static ReentrantLock look = new ReentrantLock();

    public static Long getNewID(){
        Long result;
        look.lock();//khóa biến id lại cho duy nhất một thread được truy xuất
        // để tránh tình trạng Data Racing !
        try{
            result = ++id; //tăng rồi gán vào result
        }finally {
            look.unlock();// tăng rồi thì mở look cho thread khác cùng truy cập
        }
        return result;
    }
    private IdGenerate(){}
}
