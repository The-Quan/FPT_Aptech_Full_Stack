using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex1
{
    public class StudentManaget{
        private List<Student> students;
        public StudentManaget(){
            students = new List<Student>();
        }
        public void AddStudent(Student student){
            students.Add(student);
            Console.WriteLine("Added successfully!");
        }
        public void GetAllStudent(){
            foreach(var student in students){
                Console.WriteLine(student);
            }

        }
        
    }
}