using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using ProDB.model;

namespace ProDB.service
{
    public class OrderService : IOrderRepository
    {
        private readonly string connectionString;
        public OrderService(string connectionString){
            this.connectionString = connectionString;
        }
        public void AddOrder(Order order)
        {
            // throw new NotImplementedException();
            // insert đồng thời 2 thực thể order và orderdetail 
            // đưa vào 1 transaction để đảm bảo các giao dịch diễn ra
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (var transaction = conn.BeginTransaction())
                { // start transaction
                    MySqlCommand cmd = conn.CreateCommand();
                    cmd.Transaction = transaction;
                    cmd.CommandText = "insert into orders(customer_id, order_date) value (@customerId, @orderDate)";
                    cmd.Parameters.AddWithValue("@customerId", order.CustomerId);
                    cmd.Parameters.AddWithValue("@orderDate", order.OrderDate);
                    cmd.ExecuteNonQuery();
                    int orderId = (int)cmd.LastInsertedId; // lấy id của bảng orders
                    foreach (var detail in order.OrderDetaills)
                    {
                        MySqlCommand detailCmd = conn.CreateCommand();
                        detailCmd.Transaction = transaction;
                        detailCmd.CommandText = "insert into order_details(order_id, product_id, quantity) value (@orderId, @productId, @quantity)";
                        detailCmd.Parameters.AddWithValue("@orderId", orderId);
                        detailCmd.Parameters.AddWithValue("@productId", detail.ProductId);
                        detailCmd.Parameters.AddWithValue("@quantity", detail.Quantity);
                        detailCmd.ExecuteNonQuery();
                    }

                    transaction.Commit(); // finish transaction
                }
            }
        }

        public List<Order> GetAllOrders()
        {
            // throw new NotImplementedException();
            List<Order> orders = new List<Order>();
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "select * from orders";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Order order = new Order()
                        {
                            Id = reader.GetInt32("id"),
                            CustomerId = reader.GetInt32("customer_id"),
                            OrderDate = reader.GetDateTime("order_date"),
                            Status = reader.GetString("status"),
                            OrderDetaills = new List<OrderDetaill>()
                        };
                        orders.Add(order);
                    }
                }
                //sau khi load được order từ bảng order thì cần lấy ra chi tiết của order trong orderdetail
                foreach (var order in orders)
                {
                    MySqlCommand detailCmd = conn.CreateCommand();
                    detailCmd.CommandText = "select * from order_details where order_id = @orderId";
                    detailCmd.Parameters.AddWithValue("@orderId", order.Id);
                    using (MySqlDataReader reader = detailCmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            OrderDetaill orderDetaill = new OrderDetaill()
                            {
                                ProductId = reader.GetInt32("product_id"),
                                Quantity = reader.GetInt32("quantity"),
                            };
                            order.OrderDetaills.Add(orderDetaill);
                        }
                    }
                }
            }
            return orders;
        }

        public Order GetOrderById(int id)
        {
            throw new NotImplementedException();
        }

        public void updateStatusById(int id, string status)
        {
            // throw new NotImplementedException();
            using(MySqlConnection conn = new MySqlConnection(connectionString)){
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "update orders set status = @status where id = @id";
                cmd.Parameters.AddWithValue("@id",id);
                cmd.Parameters.AddWithValue("@status", status);
                cmd.ExecuteNonQuery();
            }
        }
    }
}