package org.example.doanki2.Controller;

import org.example.doanki2.Entity.Categories;
import org.example.doanki2.Model.Categoris.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1/")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categories getCategoriesById(@PathVariable Integer id) {
        Categories categories = categoriesService.getCategoriesById(id);
        if (categories == null || !id.equals(categories.getCategory_id())) {
            throw new IllegalArgumentException("Invalid category id");
        }
        return categories;
    }
    @PostMapping
    public Categories addCategories(@RequestBody Categories categories) {
        return categoriesService.postCategories(categories);
    }
    @PutMapping("/{id}")
    public Categories updateCategories(@PathVariable Integer id, @RequestBody Categories categories) {
       if (categoriesService.getCategoriesById(id) == null || !id.equals(categories.getCategory_id())){
           throw new IllegalArgumentException("Invalid category id");
       }
       return categoriesService.updateCategories(categories);
    }
    @DeleteMapping("/{id}")
    public Categories deleteCategories(@PathVariable Integer id) {
        if (!id.equals(categoriesService.getCategoriesById(id).getCategory_id())) {
            throw new IllegalArgumentException("Invalid category id");
        }
        return categoriesService.deleteCategories(id);
    }
}
