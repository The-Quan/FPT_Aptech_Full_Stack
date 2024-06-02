using System;

class BangCuuChuong
{
    public static void Main(string[] args)
    {
        Console.Write("enter number: ");
        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i <= 10; i++)
        {
            int n2 = n * i;
            Console.WriteLine("{0} * {1} = {2}", n, i, n2);
        }
        Console.ReadLine();
    }
}
