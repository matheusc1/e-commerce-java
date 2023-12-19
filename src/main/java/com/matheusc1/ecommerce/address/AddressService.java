package com.matheusc1.ecommerce.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusc1.ecommerce.service.Generic;

@Service
public class AddressService extends Generic<AddressModel, Long> {
  
  @Autowired
  public AddressService(IAddressRepository addressRepository) {
    super(addressRepository);
  }
}
