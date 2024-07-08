package org.example.doanki2.controller;

import jakarta.validation.Valid;
import org.example.doanki2.entity.Products;
import org.example.doanki2.model.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/products/v1/")
@CrossOrigin(origins = "http://localhost:3000")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Products>> getAllProducts(@RequestParam(defaultValue = "0" ) Optional<Integer> p) {
        return productService.getAllProducts(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody @Valid Products product) {
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Integer id, @RequestBody Products products){
        return productService.updateProduct(id, products);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Products> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
