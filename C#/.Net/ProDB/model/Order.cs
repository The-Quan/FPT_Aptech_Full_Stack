using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProDB.model
{
    public class Order
    {
        public int Id { get; set; }
        public int CustomerId { get; set; }
        public DateTime OrderDate{ get; set; }
        public string Status { get; set; }
        public List<OrderDetaill> OrderDetaills{ get; set; }
        public Order(){
        OrderDetaills = new List<OrderDetaill>();
        }
    }
}