using System;

namespace Ex2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //khai báo một tham chiếu đối tượng Car có tên myCar
            Car myCar;
            //tạo một đối tượng Car và gán địa chỉ của nó cho myCar
            System.Console.WriteLine("Creating a car object and assigning " + "its memory lacation to myCar");
            myCar = new Car();

            //gán giá trị cho các trường của đối tượng Xe hơi bằng myCar
            myCar.make = "Toyota";
            myCar.model = "MR2";
            myCar.color = "black";
            myCar.yearBuilt = 1995;

            //hiển thị các giá trị trường bằng myCar
            System.Console.WriteLine("myCar details: ");
            System.Console.WriteLine("myCar.make = " + myCar.make);
            System.Console.WriteLine("myCar.model = " + myCar.model);
            System.Console.WriteLine("myCar.color = " + myCar.color);
            System.Console.WriteLine("myCar.yearBuilt = " + myCar.yearBuilt);

            // gọi các phương thức bằng myCar
            myCar.Stop();
            myCar.Start();

            // khai báo một tham chiếu đối tượng Car khác và
            //tạo một đối tượng Xe hơi khác
            System.Console.WriteLine("Creating another Car object and" + "assigning its memory location to redPorsche");
            Car redPorsChe = new Car();
            redPorsChe.make = "PorsChe";
            redPorsChe.model = "Boxster";
            redPorsChe.color = "red";
            redPorsChe.yearBuilt = 2000;
            System.Console.WriteLine("Assigning redPorsche to  myCar");
            myCar = redPorsChe;
            System.Console.WriteLine("myCar details:");
            System.Console.WriteLine("myCar.make = " + myCar.make);
            System.Console.WriteLine("myCar.model = " + myCar.model);
            System.Console.WriteLine("myCar.color = " + myCar.color);
            System.Console.WriteLine("myCar.yearBuilt = " + myCar.yearBuilt);
            // gán null cho myCar (myCar sẽ không còn tham chiếu
            // một đối tượng
            myCar = null;
            Console.ReadLine();

        }
    }
}