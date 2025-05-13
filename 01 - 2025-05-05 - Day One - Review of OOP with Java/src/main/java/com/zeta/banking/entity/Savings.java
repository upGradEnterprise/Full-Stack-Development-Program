package com.zeta.banking.entity;

import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InsufficientBalanceException;
import com.zeta.banking.exceptions.InvalidPinException;

public class Savings extends Account {
    public Savings(long newId, String accountName, double openingBalance, String pin) {
        super("SB", newId, accountName, openingBalance, pin);
    }

    @Override public double withdraw(long accountId, String pin, double amount)
            throws AccountNotFoundException, InvalidPinException, InsufficientBalanceException {
        Account account = customerService.getAccount(accountId);
        if(!account.getPin().equals(pin))
            throw new InvalidPinException("Invalid pin");
        if(account.getBalance() - amount < Account.SAVINGS_MINIMUM_BALANCE)
            throw new InsufficientBalanceException("Insufficient balance");
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        return account.getBalance();
    }
}