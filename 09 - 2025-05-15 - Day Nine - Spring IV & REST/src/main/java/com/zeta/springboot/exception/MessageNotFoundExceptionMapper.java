package com.zeta.springboot.exception;

import com.zeta.springboot.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice public class MessageNotFoundExceptionMapper {
    @ExceptionHandler(MessageNotFoundException.class) public ResponseEntity<ErrorMessage> toResponse(MessageNotFoundException mne) {
        return new ResponseEntity<>(new ErrorMessage(mne.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
}