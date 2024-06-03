using System;
class infomation
{
    class student
    {
        private string Name { get; set; }
        private string Address { get; set; }
        private string Phone { get; set; }
        public student(string Name, string Address, string Phone)
        {
            this.Name = Name;
            this.Address = Address;
            this.Phone = Phone;
        }
        public void display(){
        Console.WriteLine("----------------------");
        Console.WriteLine("name: {0}",  Name);
        Console.WriteLine("address: {0}", Address);
        Console.WriteLine("phone: {0}", Phone);
        }
    }
    public static void Main(string[] args)
    {
        Console.WriteLine("enter name: ");
        string name = Console.ReadLine();
        Console.WriteLine("enter address: ");
        string address = Console.ReadLine();
        Console.WriteLine("enter phone: ");
        string phone = Console.ReadLine();

        student d = new student(name, address, phone);
        d.display();
        
    }
}