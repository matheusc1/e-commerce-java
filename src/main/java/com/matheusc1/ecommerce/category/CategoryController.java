package com.matheusc1.ecommerce.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public CategoryModel create(@RequestBody CategoryModel category) {
    return categoryService.create(category);
  }

  @GetMapping
  public List<CategoryModel> getAll() {
    return categoryService.getAll();
  }

  @GetMapping("/{id}")
  public CategoryModel getById(@PathVariable Long id) {
    return categoryService.getById(id);
  }

  @PutMapping("/{id}")
  public CategoryModel update(@PathVariable Long id, @RequestBody CategoryModel categoryModel) {
    
    return categoryService.update(id, categoryModel);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    categoryService.delete(id);
  }
}
