import com.zeta.banking.entity.Account;
import com.zeta.banking.exceptions.AccountNotFoundException;
import com.zeta.banking.exceptions.InsufficientBalanceException;
import com.zeta.banking.exceptions.InvalidAccountTypeException;
import com.zeta.banking.exceptions.InvalidPinException;
import com.zeta.banking.services.CustomerService;
import com.zeta.banking.services.CustomerServiceImpl;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Account account;
    private static final CustomerService service = new CustomerServiceImpl();

    public static void main(String[] args) {
        accountMenu();
        transactionMenu();
    }

    private static void accountMenu() {
        int choice = -1;
        do {
            sop("Account Menu:\n");
            sop("1. Create Account\n");
            sop("2. Get Account Details\n");
            sop("3. Remove Account\n");
            sop("0. Exit\n");
            sop("Enter Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: createAccount(); break;
                case 2: getAccountDetails(); break;
                case 3: removeAccount(); break;
                case 0: break;
                default: System.err.println("Invalid Choice");
            }
        } while(choice != 0);
    }

    private static void transactionMenu() {
        int choice = -1;
        do {
            sop("Transaction Menu\n");
            sop("1. Deposit Amount\n");
            sop("2. Withdraw Amount\n");
            sop("3. Change PIN\n");
            sop("4. Get Account Balance\n");
            sop("0. Exit\n");
            sop("Enter Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: depositAmount(); break;
                case 2: withdrawAmount(); break;
                case 3: changePin(); break;
                case 4: getAccountBalance(); break;
                case 0: break;
                default: System.err.println("Invalid Choice");
            }
        } while(choice != 0);
    }

    private static void createAccount() {
        try {
            scanner.nextLine();
            sop("Account Type? ");
            String accountType = scanner.nextLine();
            if(!(accountType.equals("SB") || accountType.equals("CC")))
                throw new InvalidAccountTypeException("Account Type should be either SB | CC");
            sop("Account Name? ");
            String accountName = scanner.nextLine();
            sop("Account Opening Balance? ");
            double accountOpeningBalance = scanner.nextDouble();
            scanner.nextLine();
            sop("Account Pin? ");
            String accountPin = scanner.nextLine();
            Short.parseShort(accountPin);
            if(new StringBuilder(accountPin).reverse().toString().equals(accountPin))
                throw new InvalidPinException("Pin cannot be a Palindrome");
            long accountId = service.createAccount(accountType, accountName, accountOpeningBalance, accountPin);
            System.out.println("Account Created with ID: " + accountId);
        } catch(InsufficientBalanceException | InvalidAccountTypeException | InvalidPinException e) {
            System.err.println(e.getMessage());
        } catch(NumberFormatException nfe) {
            System.err.println("Entered Pin is Invalid");
        }
    }

    private static void getAccountDetails() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            account = service.getAccount(accountId);
            sop(account + "\n");
        } catch (AccountNotFoundException anfe) {
            System.err.println(anfe.getMessage());
        }
    }

    private static void removeAccount() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            account = service.getAccount(accountId);
            if(service.removeAccount(accountId)) sop("Account removed successfully\n");
        } catch (AccountNotFoundException anfe) {
            System.err.println(anfe.getMessage());
        }
    }

    private static void depositAmount() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            scanner.nextLine();
            sop("Pin? ");
            String pin = scanner.nextLine();
            sop("Deposit Amount? ");
            double amount = scanner.nextDouble();
            account = service.getAccount(accountId);
            sop("Amount Deposited, Balance: " + account.deposit(accountId, pin, amount) + "\n");
        } catch (AccountNotFoundException | InvalidPinException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void withdrawAmount() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            scanner.nextLine();
            sop("Pin? ");
            String pin = scanner.nextLine();
            sop("Withdraw Amount? ");
            double amount = scanner.nextDouble();
            account = service.getAccount(accountId);
            sop("Amount Withdrawn, Balance: " + account.withdraw(accountId, pin, amount) + "\n");
        } catch (AccountNotFoundException | InvalidPinException | InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void changePin() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            scanner.nextLine();
            sop("Old Pin? ");
            String oldPin = scanner.nextLine();
            Short.parseShort(oldPin);
            sop("New Pin? ");
            String newPin = scanner.nextLine();
            Short.parseShort(newPin);
            account = service.getAccount(accountId);
            if (account.changePin(accountId, oldPin, newPin)) {
                sop("Pin changed successfully\n");
            }
        } catch (AccountNotFoundException | InvalidPinException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Entered Pin is Invalid");
        }
    }

    private static void getAccountBalance() {
        try {
            sop("Account Id? ");
            long accountId = scanner.nextLong();
            account = service.getAccount(accountId);
            sop("Account Balance: " + account.getBalance() + "\n");
        } catch (AccountNotFoundException anfe) {
            System.err.println(anfe.getMessage());
        }
    }

    private static void sop(String message) { System.out.print(message); }
}