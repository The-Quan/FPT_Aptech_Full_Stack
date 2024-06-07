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
          
        public List<OrderDetaill> orderDetaills{ get; set; }
        public Order(){
        orderDetaills = new List<OrderDetaill>();
        }
    }
}