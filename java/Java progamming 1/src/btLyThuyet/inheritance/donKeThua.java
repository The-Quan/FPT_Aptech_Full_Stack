package btLyThuyet.inheritance;

public class donKeThua{
    void animal(){
        System.out.println("thong tin: ...");
    }
}
class thongTin extends donKeThua{
    void address(){
        System.out.println("dia chi: ...");
    }
}
class testThongTin{
    public static void main(String[] args) {
        thongTin d = new thongTin();
         d.address();
         d.animal();
    }
}