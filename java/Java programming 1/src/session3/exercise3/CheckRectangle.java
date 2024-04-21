package session3.exercise3;

public class CheckRectangle {
    public static void main(String[] args) {
        Rectangle h = new Rectangle(8,3);

        //hien thi hinh chu nhat
        System.out.println("Hinh chu nhat 1");
        h.display();

        //thay doi chieu cao va chieu rong
        System.out.println("Hinh chu nhat 2");
        h.setHeight(3);
        h.setWidth(10);
        h.display();

        //hien thi chu vi
        System.out.println("Chu vi hinh chu nhat: " + h.getPerimeter());

        //hien thi dien tich
        System.out.println("Dien tich hinh chu nhat: " + h.getArea());

    }
}
