package com.zeta.banking.services;

import com.zeta.banking.db.CustomerDB;
import com.zeta.banking.entity.Account;
import com.zeta.banking.entity.Current;
import com.zeta.banking.entity.Savings;
import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InsufficientBalanceException;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private Account account;

    @Override public long createAccount(String accountType, String accountName, double openingBalance, String pin)
            throws InsufficientBalanceException{
        long newId = 1 + CustomerDB.getLastCustomerId();
        if(accountType.equals("SB")) {
            if(openingBalance < Account.SAVINGS_MINIMUM_BALANCE)
                throw new InsufficientBalanceException("Savings Minimum Opening Balance: " + Account.SAVINGS_MINIMUM_BALANCE);
            account = new Savings(newId, accountName, openingBalance, pin);
        }
        else {
            if(openingBalance < Account.CURRENT_MINIMUM_BALANCE)
                throw new InsufficientBalanceException("Current Minimum Opening Balance: " + Account.CURRENT_MINIMUM_BALANCE);
            account = new Current(newId, accountName, openingBalance, pin);
        }
        CustomerDB.addCustomer(account);
        return newId;
    }

    @Override public Account getAccount(long accountId)
            throws AccountNotFoundException {
        Account account = null;
        List<Account> customers = CustomerDB.getCustomers();
        for(Account customer : customers) {
            if(customer.getAccountId() == accountId) {
                account = customer;
                break;
            }
        }
        if(account == null)
            throw new AccountNotFoundException("Account with " + accountId + " not found.");
        return account;
    }

    @Override public boolean removeAccount(long accountId)
            throws AccountNotFoundException {
        Account account = getAccount(accountId);
        CustomerDB.removeCustomer(account);
        return true;
    }
}