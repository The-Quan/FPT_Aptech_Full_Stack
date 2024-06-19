package org.example.doanki2.Model.Categoris;

import org.example.doanki2.Entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
    public Categories getCategoriesById(int id) {
        if (categoriesRepository.findById(id).isPresent()) {
            return categoriesRepository.findById(id).get();
        }
        throw new IllegalArgumentException("No such categories");
    }
    public Categories postCategories(Categories categories) {
        return categoriesRepository.save(categories);
    }
    public Categories updateCategories(Categories categories) {
        Optional<Categories> categoriesOptional = categoriesRepository.findById(categories.getCategory_id());
        if (categoriesOptional.isPresent()) {
            Categories categoriesUpdate = categoriesOptional.get();
            categoriesUpdate.setCategory_name(categories.getCategory_name());
            categoriesUpdate.setDescription(categories.getDescription());
            return categoriesRepository.save(categoriesUpdate);
        }
        throw new IllegalArgumentException("No such categories");
    }
    public Categories deleteCategories(int id) {
        if (categoriesRepository.findById(id).isPresent()) {
          categoriesRepository.deleteById(id);
        }
        return null;
    }
}
