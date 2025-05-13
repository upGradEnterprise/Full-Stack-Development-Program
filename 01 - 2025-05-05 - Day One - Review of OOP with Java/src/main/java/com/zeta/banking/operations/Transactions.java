package com.zeta.banking.operations;

import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InsufficientBalanceException;
import com.zeta.banking.exceptions.InvalidPinException;

public interface Transactions {

    public double deposit(long accountId, String pin, double amount)
            throws AccountNotFoundException, InvalidPinException;

    public double withdraw(long accountId, String pin, double amount)
            throws AccountNotFoundException, InvalidPinException, InsufficientBalanceException;

    public boolean changePin(long accountId, String oldPin, String newPin)
            throws AccountNotFoundException, InvalidPinException;

}