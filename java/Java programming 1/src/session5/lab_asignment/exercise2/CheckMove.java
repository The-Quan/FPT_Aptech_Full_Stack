package session5.lab_asignment.exercise2;

public class CheckMove {
    public static void main(String[] args) {
        System.out.println("Ket qua");
        MovablePoint mp = new MovablePoint(10,20);
        System.out.println("X = " + mp.getX() + " & " + "Y = " + mp.getY());

        mp.moveUp();
        System.out.println("MoveUp Y++: " + mp.getY());

        mp.moveDown();
        System.out.println("MoveDown Y--: " + mp.getY());

        mp.moveRight();
        System.out.println("moveRight X++: " + mp.getX());

        mp.moveLeft();
        System.out.println("MoveLeft X--: " + mp.getX());
    }
}
