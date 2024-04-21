package session6;

public class Cylinder extends Circle{
   private double height;

   public Cylinder(double radius, String color, double height){
       super(radius, color);
       this.height = height;
   }

   public double getHeight() {
      return height;
   }
   public double getVolume(){
       return getArea() * getHeight();
   }
}
