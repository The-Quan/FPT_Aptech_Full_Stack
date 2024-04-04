package session3.exercise2;

public class CheckBattery{
    public static void main(String[] args) {
        Battery battery = new Battery();
        FlashLamp flashLamp = new FlashLamp();

        flashLamp.setBattery(battery);

        for (int i = 0; i <= 15; i++) {
            System.out.println("Toggle " + i + ":");
            flashLamp.turnOn();
            System.out.println("Flashlight is on.");
            flashLamp.turnOff();
            System.out.println("Flashlight is off.");
        }

        // Display remaining battery power
        System.out.println("Remaining battery power: " + battery.getEnergy());
    }

}
