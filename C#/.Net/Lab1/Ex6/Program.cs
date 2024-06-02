/* chương trình này định dạng số trong c# */

using System;
class numberFormat{
    static void Main(string[] args){
        Console.WriteLine("Currency formatting - {0:C}{1:c4}", 88.8, 888.8);
        Console.WriteLine("Interger formatting - {0: D5}", 88);
         Console.WriteLine("Exponential formatting - {0:E}", 888.8);
        Console.WriteLine("Fixed-point formatting - {0:F3}", 888.8888);
        Console.WriteLine("General formatting - {0:G}", 888.8888);
        Console.WriteLine("Number formatting - {0:N}", 8888888.8);
        Console.WriteLine("Hexadecimal formatting - {0:X4}", 88);

    }
}