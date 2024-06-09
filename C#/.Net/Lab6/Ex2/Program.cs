
using Ex2;

class Program{
    public static void Main(string[] args){
        Thermostat thermostat = new Thermostat();
        Heater heater= new Heater(60);
        thermostat.OnTemperatureChange += heater.OnTemperatureChanged;
        Heater heaterCuong = new Heater(100);
        thermostat.OnTemperatureChange += heaterCuong.OnTemperatureChanged;

        Cooler coolor = new Cooler(80);
        thermostat.OnTemperatureChange += coolor.OnTemperatureChanged;

        string temperature;
        Console.WriteLine("Enter temperature: ");
        temperature = Console.ReadLine();
        thermostat.CurrentTemperature = int.Parse(temperature);
        Console.ReadLine();
    }
}