using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProDB.model;

namespace ProDB.service
{
    public interface IProductRepository
    {
        void Add(Product product);
        List<Product> GetAll();
    }
}