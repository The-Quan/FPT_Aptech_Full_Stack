using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProDB.model;

namespace ProDB.service
{
    public interface IOrderRepository
    {
        void AddOrder (Order order);
         List<Order> GetAllOrders ();

         Order GetOrderById(int id);

         void updateStatusById(int id, string status);
    }
}