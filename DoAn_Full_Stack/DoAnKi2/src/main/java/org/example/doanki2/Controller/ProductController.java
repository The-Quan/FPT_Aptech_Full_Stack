package org.example.doanki2.Controller;

import org.example.doanki2.Entity.Products;
import org.example.doanki2.Model.Products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Integer id) {
        Products products = productService.getProductById(id);
        if (products == null || !id.equals(products.getProduct_id())) {
            throw new IllegalArgumentException("Invalid product id");
        }
        return products;
    }
    @PostMapping
    public Products addProduct(@RequestBody Products products) {
        return productService.postProduct(products);
    }
    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Integer id,@RequestBody Products products) {
        if (productService.getProductById(id) == null || !id.equals(products.getProduct_id())) {
            throw new IllegalArgumentException("Invalid product id");
        }
        return productService.updateProduct(products);
    }
    @DeleteMapping("/{id}")
    public Products deleteProduct(@PathVariable Integer id) {
        if (!id.equals(productService.getProductById(id).getProduct_id())) {
            throw new IllegalArgumentException("Invalid product id");
        }
       return productService.deleteProduct(id);
    }
}
