package com.zeta.springboot.exception;

import com.zeta.springboot.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice public class CommentNotFoundExceptionMapper {
    @ExceptionHandler(CommentNotFoundException.class) public ResponseEntity<ErrorMessage> toResponse(CommentNotFoundException cne) {
        return new ResponseEntity<>(new ErrorMessage(cne.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
}