package com.matheusc1.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusc1.ecommerce.service.Generic;

@Service
public class ProductService extends Generic<ProductModel, Long> {
  
  @Autowired
  public ProductService(IProductRepository productRepository) {
    super(productRepository);
  }
}
