using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex4
{
    public class Program
    {
        public static void Main(string[] args){
        Employee employee = new Employee("The", "Quan", "Bac Kan", 03627165677, 50000);
        Console.WriteLine(employee.ToString());

         double bonusPercentage = 10; // Example percentage
        double bonus = employee.CalculateBonus(bonusPercentage);
        Console.WriteLine($"Bonus ({bonusPercentage}%): {bonus:C}");
        }
    }
}