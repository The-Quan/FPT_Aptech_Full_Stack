using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProDB.model;
using ProDB.service;

namespace ProDB.controller
{
         public class ProductController
    {
        private IProductRepository productService;
        public ProductController(IProductRepository productService){
            this.productService = productService;
        }
        public void AddProduct(Product product){
            productService.Add(product);
        }
        public List<Product> GetAllProducts(){
            return productService.GetAll();
        }
    }
}