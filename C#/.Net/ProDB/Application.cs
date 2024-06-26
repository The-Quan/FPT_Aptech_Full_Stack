using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProDB.controller;
using ProDB.model;
using ProDB.service;

namespace ProDB
{
    public class Program
    {
        public static void Main(string[] args)
        {
            string connetionString = "server=localhost;database=prodb;user=root;password=";
            IProductRepository productServivce = new ProductService(connetionString);
            ProductController productController = new ProductController(productServivce);

            IOrderRepository orderRepository = new OrderService(connetionString);
            OrderController orderController = new OrderController(orderRepository);
            while (true)
            {
                Console.WriteLine("My Biz Application");
                Console.WriteLine("1. Add product");
                Console.WriteLine("2. Display all products");
                Console.WriteLine("3. Add order");
                Console.WriteLine("4. Display all order");
                Console.WriteLine("5. update status");
                Console.WriteLine("6. Exit");

                Console.WriteLine("Enter your name: ");
                int choice = Convert.ToInt32(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Enter product name: ");
                        string name = Console.ReadLine();
                        Console.WriteLine("Enter price: ");
                        decimal price = Convert.ToDecimal(Console.ReadLine());
                        Console.WriteLine("Enter Decription: ");
                        string description = Console.ReadLine();
                        Product newProduct = new Product { Name = name, Price = price, Description = description };
                        // Product newProduct = new Product();
                        // newProduct.Name = name;
                        // newProduct.Price = price;
                        productController.AddProduct(newProduct);
                        Console.WriteLine("Product added successfully!!!");
                        break;
                    case 2:
                        List<Product> products = productController.GetAllProducts();
                        foreach (var product in products)
                        {
                            Console.WriteLine($"ID: {product.Id}, Name: {product.Name}, Price: {product.Price}, Description: {product.Description}");
                        }

                        break;
                    case 3:
                        Console.WriteLine("enter customer id:");
                        int orderCustomerId = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine("enter number of product: ");
                        int numberOfProduct = Convert.ToInt32(Console.ReadLine());
                        List<OrderDetaill> orderDetaills = new List<OrderDetaill>();
                        for (int i = 0; i < numberOfProduct; i++)
                        {
                            Console.WriteLine($"enter product id for product {i + 1}:");
                            int orderIdProduct = Convert.ToInt32(Console.ReadLine());
                            Console.WriteLine("enter quantity: ");
                            int quantity = Convert.ToInt32(Console.ReadLine());

                            orderDetaills.Add(new OrderDetaill { ProductId = orderIdProduct, Quantity = quantity });
                        }
                        Order order = new Order()
                        {
                            CustomerId = orderCustomerId,
                            OrderDate = DateTime.Now,
                            OrderDetaills = orderDetaills
                        };

                        orderController.AddOrder(order);
                        Console.WriteLine("Order added susccessfully!!!");
                        break;
                    case 4:
                        List<Order> orders = orderController.GetOrders();
                        foreach (var order1 in orders)
                        {
                            // list ta các đơn hàng đang có
                            Console.WriteLine($"Order id: {order1.Id}");
                            Console.WriteLine($"customet id: {order1.CustomerId}");
                            Console.WriteLine($"order detail: {order1.OrderDate}");
                            Console.WriteLine($"status: {order1.Status}");

                            foreach (var detail in order1.OrderDetaills)
                            // list ra các chi tiết đơn hàng của mỗi đơn hàng trong foreach ở trên
                            {
                                Console.WriteLine($"product id: {detail.ProductId}");
                                Console.WriteLine($"quantity: {detail.Quantity}");
                            }
                            Console.WriteLine("------------------------");
                        }
                        break;
                    case 5:
                        Console.WriteLine("enter id: ");
                        int id = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine("enter status: ");
                        string status = Console.ReadLine();
                        orderController.updateStatusById(id, status);
                        Console.WriteLine("update status successfully");
                        break;
                    case 6: return;
                    default:
                        Console.WriteLine("Invalid choice! pls try again");
                        break;
                }



            }

        }
    }
}