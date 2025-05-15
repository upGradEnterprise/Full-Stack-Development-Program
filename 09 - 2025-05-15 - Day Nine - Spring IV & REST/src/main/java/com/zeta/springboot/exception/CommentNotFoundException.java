package com.zeta.springboot.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message) { super(message); }
}