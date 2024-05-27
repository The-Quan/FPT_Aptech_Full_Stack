public class Math {
    private double width;
    private double height;

    public Math(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double perimeterRectangle(){
       return (width + height) * 2 ;
    }
    public double areaRectangle(){
        return width * height;
    }
    public double perimeterSquare(){
        return width * 4;
    }
    public double areaSquare(){
        return width * width;
    }

    public void display(){
        System.out.println("chu vi hinh chu nhat la: " + this.perimeterRectangle());
        System.out.println("dien tinh hinh chu nhat la: " + this.areaRectangle());
        System.out.println("chu vi hinh vuong la: " + this.perimeterSquare());
        System.out.println("dien tich hinh vuong la: " + this.areaSquare());
    }

    public static void main(String[] args) {
        Math math = new Math(3,5);
        math.display();
    }
}
