package session5.lab_asignment.exercise2;

public class MovablePoint implements Movable{
 private double x;
 private double y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
       y-- ;
    }

    @Override
    public void moveLeft() {
        x-- ;
    }

    @Override
    public void moveRight() {
       x++ ;
    }
}
