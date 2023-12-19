package com.matheusc1.ecommerce.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
  
}
