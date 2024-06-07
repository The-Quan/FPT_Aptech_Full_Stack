using ProDB.model;
using MySql.Data.MySqlClient;

namespace ProDB.service
{
    public class ProductService : IProductRepository
    {
        private MySqlConnection conn;
        public ProductService(string connetionString)
        {
            conn = new MySqlConnection(connetionString);
        }

        public void Add(Product product)
        {
            conn.Open();
            MySqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = "insert into products(name,price,description) values(@Name,@Price,@Description)";
            cmd.Parameters.AddWithValue("@Name", product.Name);
            cmd.Parameters.AddWithValue("@Price", product.Price);
            cmd.Parameters.AddWithValue("@Description", product.Description);
            cmd.ExecuteNonQuery();
            conn.Close();

        }

        public List<Product> GetAll()
        {
            conn.Open();
            MySqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = "select * from products";
            MySqlDataReader reader = cmd.ExecuteReader();//java ko co 
            List<Product> products = new List<Product>();
            while(reader.Read())
            {//resulSet.next() cua java
                Product product = new Product{
                    Id = Convert.ToInt32(reader["id"]),
                    Name = reader["name"].ToString(),
                    Price = Convert.ToDecimal(reader["price"]),
                    Description = reader["description"].ToString()
                };
                products.Add(product);
            }
            conn.Close();
            return products;
        }
    }
}