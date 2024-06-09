public abstract class GeometricObject{
    protected string color;
    protected double weight;
    // construct mac dinh
    protected GeometricObject(){
        color = "while";
        weight = 1.0;
    }
    // Xây dựng một đối tượng hình học
    protected GeometricObject(string color, double weight){
        this.color = color;
        this.weight = weight;
    }
    //properties
    public string PColor{
        get{return color;}
        set{color = value;}
    }
    // properties
    public double Pweight{
        get{return weight;}
        set {weight = value;}
    }
    // abstract method
    public abstract double findArea();
    // abstract method
    public abstract double findPerimeter();
}