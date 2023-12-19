package com.matheusc1.ecommerce.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matheusc1.ecommerce.product.ProductModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "categories")
public class CategoryModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_category")
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;
  
  @OneToMany(mappedBy = "category")
  @JsonManagedReference
  private List<ProductModel> products;
}
