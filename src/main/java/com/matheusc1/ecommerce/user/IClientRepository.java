package com.matheusc1.ecommerce.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientModel, Long> {
  
}
