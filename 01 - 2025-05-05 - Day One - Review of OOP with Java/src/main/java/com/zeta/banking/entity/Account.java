package com.zeta.banking.entity;

import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InvalidPinException;
import com.zeta.banking.operations.Transactions;
import com.zeta.banking.services.CustomerService;
import com.zeta.banking.services.CustomerServiceImpl;

public abstract class Account implements Transactions {
    public static final double CURRENT_MINIMUM_BALANCE = 5000.0;
    public static final double SAVINGS_MINIMUM_BALANCE = 100.0;

    private final String accountType;
    private final long accountId;
    private final String accountName;
    private double balance;
    private String pin;

    protected static CustomerService customerService = new CustomerServiceImpl();

    public Account(String accountType, long newId, String accountName, double openingBalance, String pin) {
        this.accountType = accountType;
        this.accountId = newId;
        this.accountName = accountName;
        this.balance = openingBalance;
        this.pin = pin;
    }

    public long getAccountId() { return accountId; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getPin() { return pin; }

    @Override public double deposit(long accountId, String pin, double amount)
            throws AccountNotFoundException, InvalidPinException {
        Account account = customerService.getAccount(accountId);
        if(!account.pin.equals(pin))
            throw new InvalidPinException("Invalid pin");
        account.balance += amount;
        return account.balance;
    }

    @Override public boolean changePin(long accountId, String oldPin, String newPin)
            throws AccountNotFoundException, InvalidPinException {
        Account account = customerService.getAccount(accountId);
        if(!account.pin.equals(oldPin))
            throw new InvalidPinException("Invalid pin");
        if(account.pin.equals(newPin))
            throw new InvalidPinException("Old pin cannot be the same as the new pin");
        if(new StringBuilder(newPin).reverse().toString().equals(newPin))
            throw new InvalidPinException("New pin cannot be palindrome");
        this.pin = newPin;
        return true;
    }

    @Override public String toString() {
        return "Account [accountType=" + accountType + ", accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance + ", pin=" + pin + "]";
    }
}