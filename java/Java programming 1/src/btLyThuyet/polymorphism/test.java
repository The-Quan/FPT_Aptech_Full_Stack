package btLyThuyet.polymorphism;

class daHinh {
  int daHinh = 1000;
}
class daHinh2 extends daHinh{
    int daHinhg2 = 2000;
}
class daHinh3 extends daHinh{
  int daHinhg3 = 3000;
}
public class test {
    public static void main(String[] args) {
        System.out.println("ket qua");
        daHinh h = new daHinh3() ;
        System.out.println("hien thi: " + h.daHinh);
        h = new daHinh2();
        System.out.println("hien thi: " + ((daHinh2) h).daHinhg2);
        h = new daHinh3();
        System.out.println("hien thi: " + ((daHinh3) h).daHinhg3);
    }
}