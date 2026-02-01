package com.atul.prod_ready_features.advice;

import com.atul.prod_ready_features.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException ex){
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"Resource Not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
