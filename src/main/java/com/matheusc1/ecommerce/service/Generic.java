package com.matheusc1.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusc1.ecommerce.exception.ResourceNotFoundException;
import com.matheusc1.ecommerce.utils.Utils;


public class Generic<T, ID> {
  
  private final JpaRepository<T, ID> repository;

  public Generic(JpaRepository<T, ID> repository) {
    this.repository = repository;
  }

  public T create(T entity) {
    return repository.save(entity);
  }

  public List<T> getAll() {
    List<T> entities = repository.findAll();

    return entities;
  }

  public T getById(ID id) {
    Optional<T> optEntity = repository.findById(id);

    if (optEntity.isEmpty()) {
      throw new ResourceNotFoundException("Não foi possível encontrar o item com id: " + id);
    }

    return optEntity.get();
  }

  public T update(ID id, T entity) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Item com o id: " + id + " não encontrado");
    }

    T entityT = repository.findById(id).orElseThrow(() -> 
      new ResourceNotFoundException("Item com o id: " + id + " não encontrado"));

    try {
      Utils.copyNonNullProperties(entity, entityT);

      entity.getClass().getMethod("setId", id.getClass()).invoke(entity, id);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao copiar propriedades ou setar o id", e);
    }

    return repository.save(entityT);
  }

  public void delete(ID id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Item com o id: " + id + " não encontrado");
    }

    repository.deleteById(id);
  }
}
