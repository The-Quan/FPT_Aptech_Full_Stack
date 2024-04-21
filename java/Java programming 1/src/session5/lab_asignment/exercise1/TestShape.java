package session5.lab_asignment.exercise1;

public class TestShape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        Triangle triangle = new Triangle(4,6);

        System.out.println("Area of rectangle: " + rectangle.getArea());
        System.out.println("Area of triangle: " + triangle.getArea());
    }
}
