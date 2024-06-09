using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex2
{
    public class Heater
    {
        public Heater(float temperature){
            Temperature = temperature;
        }
        public float Temperature { get; set; }
        private float _Temperature;
        public void OnTemperatureChanged(float newTemperature){
            if(newTemperature < Temperature){
                System.Console.WriteLine("Heater: On");
            }else{
                System.Console.WriteLine("Heater: off");
            }
        }
    }
}