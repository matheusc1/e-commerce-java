package com.matheusc1.ecommerce.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusc1.ecommerce.service.Generic;

@Service
public class ClientService extends Generic<ClientModel, Long> {
  
  @Autowired
  public ClientService(IClientRepository clientRepository) {
    super(clientRepository);
  }
}
