package org.example.doanki2.model.categoris;

import org.example.doanki2.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

  public ResponseEntity<List<Categories>> getAllCategories(){
      List<Categories> categoriesList = categoriesRepository.findAll();
      return ResponseEntity.ok(categoriesList);
  }

  public ResponseEntity<Categories> getByIdCategory(int id){
      Optional<Categories> categoriesOptional = categoriesRepository.findById(id);
      if (!categoriesOptional.isPresent()){
          throw new IllegalArgumentException("id not found");
      }
      return ResponseEntity.ok(categoriesOptional.get());
  }
  public ResponseEntity<Categories> postCategory(Categories categories){
      Categories category = categoriesRepository.save(categories);
      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getCategory_id()).toUri();

      return ResponseEntity.created(location).body(category);
  }
  public ResponseEntity<Categories> putCategory(int id, Categories categories){
      Optional<Categories> categoriesOptional = categoriesRepository.findById(id);
      if (!categoriesOptional.isPresent()){
          throw new IllegalArgumentException("id not found");
      }
      categories.setCategory_id(categoriesOptional.get().getCategory_id());
      categoriesRepository.save(categories);
      return ResponseEntity.ok().body(categories);
  }
  public ResponseEntity<Categories> deleteCategory(int id){
      Optional<Categories> categoriesOptional = categoriesRepository.findById(id);
      if (!categoriesOptional.isPresent()){
          throw new IllegalArgumentException("id not found");
      }
      categoriesRepository.deleteById(categoriesOptional.get().getCategory_id());
      return ResponseEntity.noContent().build();
  }
}
