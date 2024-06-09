using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex1
{
    public class Program
    {
        static void Main(string[] args){
            Circle c1 = new Circle(2.45, "Blue", 23);
            Console.WriteLine("Circle after change: "+c1.ToString());
    
            // sử dụng thuộc tính
            c1.Pweight = 2.56;
            c1.PColor =  "red";
            Console.WriteLine("circle after change: " + c1.ToString());
            Console.ReadLine();
        }
    }
}