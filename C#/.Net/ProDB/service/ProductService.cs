using ProDB.model;
using MySql.Data.MySqlClient;

namespace ProDB.service
{
    public class ProductService : IProductRepository
    {
        private MySqlConnection conn;
       
        public void Add(Product product)
        {
        
        }

        public List<Product> GetAll()
        {
            throw new NotImplementedException();
        }
    }
}