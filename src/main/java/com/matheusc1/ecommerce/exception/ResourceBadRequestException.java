package com.matheusc1.ecommerce.exception;

public class ResourceBadRequestException extends RuntimeException {
  
  public ResourceBadRequestException (String message) {
    super(message);
  }
}
