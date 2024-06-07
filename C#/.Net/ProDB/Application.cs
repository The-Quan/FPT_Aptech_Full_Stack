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
            while (true)
            {
                Console.WriteLine("My Biz Application");
                Console.WriteLine("1. Add product");
                Console.WriteLine("2. Display all products");
                Console.WriteLine("3. Exit");

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
                    case 3: return;
                    default:
                        Console.WriteLine("Invalid choice! pls try again");
                        break;
                }



            }

        }
    }
}