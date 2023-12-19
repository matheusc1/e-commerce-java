package com.matheusc1.ecommerce.exception;

import lombok.Data;

@Data
public class ExceptionModel {

  private String title;
  private String message;
  private Integer status;

  public ExceptionModel(String title, String message, Integer status) {
    this.title = title;
    this.message = message;
    this.status = status;
  }
}
