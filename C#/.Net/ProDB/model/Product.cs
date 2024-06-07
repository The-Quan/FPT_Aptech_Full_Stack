using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProDB.model
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public decimal price {get; set;}
        public string description{get;set;}

    }
}