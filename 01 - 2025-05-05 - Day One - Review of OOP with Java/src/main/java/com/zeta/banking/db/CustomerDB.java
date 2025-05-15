package com.zeta.banking.db;

import com.zeta.banking.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    private static List<Account> customers = new ArrayList<Account>();

    public static long getLastCustomerId() {
        long lastId = 0;
        if(!customers.isEmpty()) {
          for(Account account : customers) {
              lastId = account.getAccountId();
          }
        }
        return lastId;
    }

    public static void addCustomer(Account account) { customers.add(account); }

    public static void removeCustomer(Account account) { customers.remove(account); }

    public static List<Account> getCustomers() { return customers; }
}