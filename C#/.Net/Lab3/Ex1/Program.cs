using System;
namespace Ex1{
    class Program{
        public static void Main(string[] args)
        {
            //cach1 
            StudentManaget studentMagement = new StudentManaget();
            //Cach2
            //var khai bao biet Khong dinh danh 
            // var studentManager = new StudentManager();
            while(true){
                Console.WriteLine("Student Management System");
                Console.WriteLine("1. Add Student");
                Console.WriteLine("2. Display Students");
                Console.WriteLine("3. Exit");
                var choice = Console.ReadLine();

                switch(choice){
                    case "1": 
                            Student student = new Student();
                            Console.WriteLine("Enter student id: ");
                            student.Id = int.Parse(Console.ReadLine());
                            Console.WriteLine("Enter student name: ");
                            student.Name = Console.ReadLine();
                            Console.WriteLine("Enter student age: ");
                            student.Age = int.Parse(Console.ReadLine());     
                            studentMagement.AddStudent(student);

                        break;
                    case "2": studentMagement.GetAllStudent();
                        break;
                    case "3": return;
                    default:
                        Console.WriteLine("Invalid choice, pls try again");
                        break;
                }
        
            }

        }
    }

}