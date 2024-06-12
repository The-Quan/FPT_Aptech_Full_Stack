public class Car {
    private int speed;
    private BMW bmw;
    private Lamborghini lamborghini;

    public Car(int speed, BMW bmw, Lamborghini lamborghini) {
        this.speed = speed;
        this.bmw = bmw;
        this.lamborghini = lamborghini;
    }

    public Car() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BMW getBmw() {
        return bmw;
    }

    public void setBmw(BMW bmw) {
        this.bmw = bmw;
    }

    public Lamborghini getLamborghini() {
        return lamborghini;
    }

    public void setLamborghini(Lamborghini lamborghini) {
        this.lamborghini = lamborghini;
    }
}
