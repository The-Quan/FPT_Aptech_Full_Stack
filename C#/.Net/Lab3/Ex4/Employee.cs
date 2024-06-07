using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex4
{
    public class Employee
    {
        private string firstName{ get; set; }
        private string lastName{ get; set; }
        private string address{ get; set; }
        private long sin{ get; set; }
        private double salary{ get; set; }
        public Employee(string firstName, string lastName, string address, long sin, double salary){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.sin = sin;
            this.salary = salary;
        }
         public double CalculateBonus(double percentage)
        {
            return salary * (percentage / 100);
        }
        public  override string ToString(){
           return $"Employee: {firstName} {lastName}, Address: {address}, SIN: {sin}, Salary: {salary:C}";
        }
    }
}