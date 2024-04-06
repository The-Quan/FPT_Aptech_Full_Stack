package session5.lab_asignment.exercise3;

public class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;
    public MovableCircle(MovablePoint center, int  radius){
        this.center = center;
        this.radius = radius;
    }


    @Override
    public void moveUp() {
        this.center.setX(this.center.getX() + this.center.getxSpeed());
    }

    @Override
    public void MoveDown() {
        this.center.setX(this.center.getX() - this.center.getxSpeed());
    }

    @Override
    public void MoveLeft() {
        this.center.setY(this.center.getY() - this.center.getySpeed());

    }

    @Override
    public void MoveRight() {
        this.center.setY(this.center.getY() + this.center.getySpeed());
    }

    @Override
    public String toString() {
        return "MovableCircle {" +
                "radius = " + radius +
                ", center = " + center +
                '}';
    }
}
