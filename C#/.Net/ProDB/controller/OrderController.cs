using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProDB.model;
using ProDB.service;

namespace ProDB.controller
{
    public class OrderController
    {
        private IOrderRepository orderRepository;
        public OrderController(IOrderRepository orderRepository){
            this.orderRepository = orderRepository;
        }
        public void AddOrder (Order order){
            orderRepository.AddOrder (order);
        }
        public List<Order> GetOrders(){
            return orderRepository.GetAllOrders();
        }
        public Order GetOrderById (int id){
            return orderRepository.GetOrderById(id);
        }
        public void updateStatusById(int id, string status){
            orderRepository.updateStatusById(id, status);
        }
    }
}