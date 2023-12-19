package com.matheusc1.ecommerce.product;

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
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<ProductModel> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public ProductModel getById(@PathVariable Long id) {
    return productService.getById(id);
  }

  @PostMapping
  public ProductModel create(@RequestBody ProductModel product) {
    return productService.create(product);
  }

  @PutMapping("/{id}")
  public ProductModel update(@PathVariable Long id, @RequestBody ProductModel product) {
    return productService.update(id, product);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productService.delete(id);
  }
}
