package com.matheusc1.ecommerce.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusc1.ecommerce.service.Generic;

@Service
public class CategoryService extends Generic<CategoryModel, Long> {
  
  @Autowired
  public CategoryService(ICategoryRepository categoryRepository) {
    super(categoryRepository);
  }
}