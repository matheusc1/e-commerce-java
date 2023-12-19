package com.matheusc1.ecommerce.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matheusc1.ecommerce.exception.ResourceBadRequestException;
import com.matheusc1.ecommerce.user.ClientModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "addresses")
public class AddressModel {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String cep;

  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  private String number;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String state;

  private String complement;

  @ManyToOne
  @JoinColumn(name = "client_id")
  @JsonBackReference
  private ClientModel client;

  public void setCep(String cep) {
    if (cep.length() != 8) {
      throw new ResourceBadRequestException("O cep deve conter 8 caracteres");
    }
    this.cep = cep;
  }
}

