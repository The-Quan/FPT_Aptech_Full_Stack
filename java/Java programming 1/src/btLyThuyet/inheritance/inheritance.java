package btLyThuyet.inheritance;
// kế thừa lại main
public class inheritance {
    public static void main(String[] args) {
        System.out.println("thanh cong");
        gamer l = new gamer();
        //gamer là lớp con của main nên được gợi vì có cả 2 trường salary và bonus
        System.out.println("salary: " + l.salary);
        System.out.println("bonus: " + l.bonus);
    }
}
class main {
    //main là lớp cha của gamer
    float salary = 1000;
}
class gamer extends main {
    //gamer là lớp con của gamer nên đc truy cập đến trường salary
    int bonus = 1500;
}
