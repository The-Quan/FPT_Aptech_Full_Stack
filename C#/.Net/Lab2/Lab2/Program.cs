using System;
class ForEach{
    static void Main(string[] args){
        DateTime dateTime= DateTime.Now;
        Random rand = new Random((int)dateTime.Millisecond);
        int[] arr = new int[10];
        for(int i=0; i < arr.Length; i++){
            arr[i] = rand.Next() % 100;
        }
        int Total = 0;
        Console.WriteLine("array value are ");
        foreach(int i in arr){
            Total += i;
            Console.WriteLine(i + ", ");
        }
        Console.WriteLine("\n and the aversge is {0,0}", (double)Total / (double)arr.Length);
        Console.ReadLine();
    }
}