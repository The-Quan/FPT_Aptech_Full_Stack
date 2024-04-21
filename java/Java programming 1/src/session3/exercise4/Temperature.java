package session3.exercise4;

public class Temperature {
    private double cTemp;

    public Temperature(double cTemp){
        this.cTemp = cTemp;
    }
    public void setcTemp(double celsius){
        this.cTemp = celsius;
    }
    public double getcTemp(){
        return this.cTemp;
    }
    // Chuyen tu do C sang nhiet do F
    public double getFTemp(){
        return (cTemp * 9 / 5) + 32;
    }
    // Chuyen tu do C sang nhiet do k
    public double getKTem(){
        return cTemp + 273.15;
    }

}
