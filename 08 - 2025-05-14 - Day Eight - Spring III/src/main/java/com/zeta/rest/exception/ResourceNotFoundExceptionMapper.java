package com.zeta.rest.exception;

import com.zeta.rest.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice public class ResourceNotFoundExceptionMapper  {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> toResponse(ResourceNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}