package org.example.doanki2.controller;

import org.example.doanki2.entity.Categories;
import org.example.doanki2.model.categoris.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories(){
        return categoriesService.getAllCategories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categories> getByIdCategories(@PathVariable Integer id){
        return categoriesService.getByIdCategory(id);
    }
    @PostMapping
    public ResponseEntity<Categories> postCategory(@RequestBody Categories categories){
        return categoriesService.postCategory(categories);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categories> putCategory(@PathVariable Integer id, @RequestBody Categories categories){
        return categoriesService.putCategory(id, categories);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Categories> deleteCategory(@PathVariable Integer id){
        return categoriesService.deleteCategory(id);
    }
}
