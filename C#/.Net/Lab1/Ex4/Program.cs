using System;
using System.Text;
class Example{
    static void Test(int valueVal){
        int temp = 5;
        valueVal = temp * 2;
    }
    static void Main(string[] args)
    {
        int valueVal = 5;
        Test (valueVal);
        Console.WriteLine("the value of the variable is {0}", valueVal);
        Console.ReadLine();
    }
}