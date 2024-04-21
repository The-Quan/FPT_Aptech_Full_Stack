package session5.lab_asignment.exercise3;

public class CheckMovable {
    public static void main(String[] args) {
        MovablePoint mbp = new MovablePoint(4,2,4,5);
        MovableCircle mbc = new MovableCircle(mbp, 4);

        System.out.println("Phuong thuc ban dau:");

        System.out.println(mbc.toString()); // in ra một chuỗi biểu diễn của đôi tượng mbc

        mbc.MoveRight();// tham chiếu đối tượng mcb và gọi method MoveRight()
        System.out.println("MoveRight:");
        System.out.println(mbc.toString());

        mbc.MoveLeft();
        System.out.println("MoveLeft:");
        System.out.println(mbc.toString());

        mbc.moveUp();
        System.out.println("MoveUp:");
        System.out.println(mbc.toString());

        mbc.MoveDown();
        System.out.println("MoveDown:");
        System.out.println(mbc.toString());


    }
}
