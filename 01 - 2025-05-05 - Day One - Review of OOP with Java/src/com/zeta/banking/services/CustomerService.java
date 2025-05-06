package com.zeta.banking.services;

import com.zeta.banking.entity.Account;
import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InsufficientBalanceException;

public interface CustomerService {

    public long createAccount(String accountType, String accountName, double openingBalance, String pin)
            throws InsufficientBalanceException;

    public Account getAccount(long accountId)
            throws AccountNotFoundException;

    public boolean removeAccount(long accountId)
            throws AccountNotFoundException;

}