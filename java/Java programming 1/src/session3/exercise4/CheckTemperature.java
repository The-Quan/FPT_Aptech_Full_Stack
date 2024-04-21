package session3.exercise4;

public class CheckTemperature {
    public static void main(String[] args) {
        Temperature c = new Temperature(26.7);

        System.out.println("Hien thi do C: " + c.getcTemp());


        System.out.println("Hien thi do F: " + c.getFTemp());

        System.out.println("Hien thi do K: " + c.getKTem());

    }
}
