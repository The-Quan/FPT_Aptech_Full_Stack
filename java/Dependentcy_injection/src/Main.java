public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        BMW bmw = new BMW();
        Lamborghini lamborghini = new Lamborghini();
        car1.setSpeed(100);
        car1.setBmw(bmw);
        car1.setLamborghini(lamborghini);

        System.out.println(car1.getLamborghini().run()+" "+car1.getSpeed());
        System.out.println(car1.getBmw().run()+" "+car1.getSpeed());
    }

}
