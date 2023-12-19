package com.matheusc1.ecommerce.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheusc1.ecommerce.exception.ExceptionModel;
import com.matheusc1.ecommerce.exception.ResourceBadRequestException;
import com.matheusc1.ecommerce.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex) {
    ExceptionModel err = new ExceptionModel("Not found", ex.getMessage(), 404);

    return ResponseEntity.status(404).body(err);
  }

  @ExceptionHandler(ResourceBadRequestException.class)
  public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex) {
    ExceptionModel err = new ExceptionModel("Bad request", ex.getMessage(), 400);

    return ResponseEntity.status(400).body(err);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handlerResourceException(Exception ex){

    ExceptionModel err = new ExceptionModel("Internal Server Error", ex.getMessage(), 500);
    return ResponseEntity.status(500).body(err);
  }
}
