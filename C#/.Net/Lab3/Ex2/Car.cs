using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex2
{
    public class Car
    {
        public string make;
        public string model;
        public string color;
        public int yearBuilt;
        public void Start(){
            System.Console.WriteLine(model + " started");
        }
        public void Stop(){
            System.Console.WriteLine(model + " stopped");
        }
    }
}