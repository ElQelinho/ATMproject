package com.example;

import com.example.menu.MenuContext;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Bank {
    //    bank name
    private final String bankName = "Black Empire Bank";
    //  accounts Array
    ArrayList<Account> bankAccounts = new ArrayList<>();

    ATM atm;

    BigDecimal newBalance;

    BigDecimal clientBalance;

    MenuContext menuContext;

    Account userAccount;

    Account clientAccount;
    public Bank() {
        this.createAccount("Lora", "Palmer", 2024, (byte) 7);
        this.createAccount("Max", "Frolov", 2010, (byte) 92);
        this.createAccount("Gorby", "Jason", 2034, (byte) 15);
    }

    private ArrayList<Account> createAccount(String firstUserName, String secondUserName, int cardNum, byte pin) {
        Account bankAccount = new Account(firstUserName, secondUserName, cardNum, pin);
        bankAccount.setBalance(new BigDecimal(0));
        bankAccounts.add(bankAccount);
        return bankAccounts;
    }

    //    print Accounts
    public void printAccounts() {
        for (Account acc : bankAccounts) {
            System.out.println("-----------------------------------");
            System.out.print("Name: " + acc.getFirstUserName() + " ");
            System.out.println(acc.getSecondUserName());
            System.out.println("Card number: " + acc.getCardNum());
            System.out.println("Pin code: " + acc.getPin());
            System.out.println("Cash: $" + acc.getBalance());
            System.out.println("-----------------------------------");
        }
    }

    //    printBankName
    public String printBankName() {
        return bankName;
    }

    public Account fetchAccount(int card, byte pin) {
        for (Account acc : bankAccounts) {
            if ((acc.getCardNum() == card) && (acc.getPin() == pin)) {
                return acc;
            }
        }
        return null;
    }

    public void register(ATM atm) {
        this.atm = atm;
        atm.setBank(this);
    }

    public MenuContext incomeBalance(BigDecimal income, MenuContext userContext) {
        menuContext = userContext;
        userAccount = menuContext.getAuthUser();
        newBalance = userAccount.getBalance();
        userAccount.setBalance(newBalance.add(income));
        menuContext.setAccount(userAccount);
        return menuContext;
    }

    public MenuContext stealBalance(BigDecimal steal, MenuContext userContext) {
        menuContext = userContext;
        userAccount = menuContext.getAuthUser();
        newBalance = userAccount.getBalance();
        if (newBalance.compareTo(steal) == -1) {
            System.out.println("Operation denied, low balance");
            return menuContext;
        }
        userAccount.setBalance(newBalance.subtract(steal));
        menuContext.setAccount(userAccount);
        return menuContext;
    }

    public MenuContext transferAccount(int cardNumber,BigDecimal money,MenuContext userContext) {
        menuContext = userContext;
        for (Account acc : bankAccounts) {
            if ((acc.getCardNum() == cardNumber)) {
                clientAccount = acc;
            }
        }

        clientBalance = clientAccount.getBalance();
        System.out.println(clientAccount.getFirstUserName());
        System.out.println(clientAccount.getBalance());
        userAccount = menuContext.getAuthUser();
        newBalance = userAccount.getBalance();
        if (newBalance.compareTo(money) == -1) {
            System.out.println("Operation denied, low balance");
            return menuContext;
        }

        userAccount.setBalance(newBalance.subtract(money));
        clientAccount.setBalance(clientBalance.add(money));
        System.out.println("Transfer complete!");
        menuContext.setAccount(userAccount);
        return menuContext;
    }
}


