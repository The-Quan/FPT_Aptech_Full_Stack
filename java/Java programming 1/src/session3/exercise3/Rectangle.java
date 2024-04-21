package session3.exercise3;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void display(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                System.out.print("8");
            }
            System.out.println(" ");
        }
    }
    public int getArea(){
       return this.width * this.height;
    }
    public int getPerimeter(){
        return (this.width + this.height) * 2;
    }
}
