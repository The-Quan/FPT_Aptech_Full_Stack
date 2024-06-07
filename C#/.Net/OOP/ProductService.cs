using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Org.BouncyCastle.Asn1.Misc;

namespace OOP
{
    public class ProductService : IProductRepository
    {
        private string connection = "Server=127.0.0.1;Database=prodb;User=root;Password=";
        public void Create(Product product)
        {
            // throw new NotImplementedException();
            using (MySqlConnection conn = new MySqlConnection(connection)){
                conn.Open();
                string query = "insert into product (name, price, description) values(@name, @price, @description)";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@name", product.Name);
                cmd.Parameters.AddWithValue("@price", product.Price);
                cmd.Parameters.AddWithValue("@description", product.Description);
                cmd.ExecuteNonQuery();
            }
        }

        public void Delete(int id)
        {
            // throw new NotImplementedException();
            using (MySqlConnection conn = new MySqlConnection(connection)){
                conn.Open();
                string query = "delete from product where id = @id";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@id", id);
                cmd.ExecuteNonQuery();
            }
        }

        public List<Product> GetAll()
        {
            // throw new NotImplementedException();
            List<Product> products = new List<Product>();
            // using hay try..catech
            using(MySqlConnection conn = new MySqlConnection(connection))
            {
                conn.Open();
                string query = "select * from product";
                MySqlCommand cmd = new MySqlCommand(query, conn);
                using (var read = cmd.ExecuteReader())
                {
                    while (read.Read())
                    {
                        products.Add(new Product
                        {
                            Id = read.GetInt32("id"),
                            Name = read.GetString("name"),
                            Price = read.GetDecimal("price"),
                            Description = read.GetString("description")
                        });

                    }
                }
                return products;
            }
        }


        public Product Read(int id)
        {
            // throw new NotImplementedException();
            using (MySqlConnection conn = new MySqlConnection(connection)){
                conn.Open();
                string read = "select * from product where id = @id";
                MySqlCommand cmd = new MySqlCommand(read, conn);
                cmd.Parameters.AddWithValue("@id", id);
                using(var read2 = cmd.ExecuteReader()){
                    if (read2.Read()){
                        Product product = new Product{
                            Id = read2.GetInt32("id"),
                            Name = read2.GetString("name"),
                            Price = read2.GetDecimal("price"),
                            Description = read2.GetString("description")
                        };
                        return product;
                    }
                }
            }
            return null;
        }

        public void Update(Product product)
        {
            // throw new NotImplementedException();
            using (MySqlConnection conn = new MySqlConnection(connection)){
                conn.Open();
                string update = "update product set  name = @name, price = @price, description =  @description where id = @id";
                MySqlCommand cmd = new MySqlCommand(update, conn);
                cmd.Parameters.AddWithValue("@id", product.Id);
                cmd.Parameters.AddWithValue("@name", product.Name);
                cmd.Parameters.AddWithValue("@price", product.Price);
                cmd.Parameters.AddWithValue("@description", product.Description);
               cmd.ExecuteNonQuery();
            }
        }

    }
}