using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex1
{
    public class Student
    {
       public  int Id{get;set;}
       public  string Name{get;set;}
        public  int Age{get;set;}

        public override string ToString()
    {
        return "id" + Id + "name" + "age" + Age;
    }
    }
}