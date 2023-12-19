package com.matheusc1.ecommerce.user;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matheusc1.ecommerce.address.AddressModel;
import com.matheusc1.ecommerce.exception.ResourceBadRequestException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "clients")
public class ClientModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(length = 11)
  private String cpf;

  @Column(nullable = false)
  private String email;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  @JsonManagedReference
  private List<AddressModel> addresses;

  public void setCPF(String cpf) throws Exception {
    if (cpf.length() != 11) {
      throw new ResourceBadRequestException("O cpf deve conter 11 caracteres");
    }
    this.cpf = cpf;
  }
}
