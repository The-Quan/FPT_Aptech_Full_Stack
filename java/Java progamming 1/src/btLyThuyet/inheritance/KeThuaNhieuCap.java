package btLyThuyet.inheritance;

public class KeThuaNhieuCap {
    void cap1(){
        System.out.println("thanh cong cap 1");
    }
}
class KeThuaCap2 extends KeThuaNhieuCap {
    void cap2() {
        System.out.println("thanh cong cap 2");
    }
}
class  KeThuaCap3 extends KeThuaCap2{
    void cap3(){
        System.out.println("thanh cong cap 3");
    }
}
class test{
    public static void main(String[] args) {
        System.out.println("ket qua");
        KeThuaCap3 h = new KeThuaCap3();
        h.cap1();
        h.cap2();
        h.cap3();
    }
}

