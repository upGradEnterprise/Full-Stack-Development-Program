package com.zeta.banking.exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}