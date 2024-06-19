package org.example.doanki2.Model.Products;

import org.example.doanki2.Entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
    public Products getProductById(int id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        throw new IllegalArgumentException("Product not found");
    }
    public Products postProduct(Products product){
        return productRepository.save(product);
    }
    public Products updateProduct(Products product){
        Optional<Products> productsOptional = productRepository.findById(Math.toIntExact(product.getProduct_id()));
        if(productsOptional.isEmpty()){
            throw new IllegalArgumentException("Product not found");
        }
        Products productToUpdate = productsOptional.get();
        productToUpdate.setProduct_name(product.getProduct_name());
        productToUpdate.setCategoris(product.getCategoris());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setImageUrl(product.getImageUrl());
        return productRepository.save(productToUpdate);
    }
    public Products deleteProduct(int id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
        return null;
    }
}
