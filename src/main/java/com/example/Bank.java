package com.example;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public class Bank {
    //    bank name
    private final String bankName = "Black Empire Bank";
    //  accounts Array
    ArrayList<Account> bankAccounts = new ArrayList<>();

    ATM atm;
    public Bank() {
        this.createAccount("Lora", "Palmer", 2024, (byte) 7);
        this.createAccount("Max", "Frolov", 2010, (byte) 92);
        this.createAccount("Gorby", "Jason", 2034, (byte) 15);
    }

    private void createAccount(String firstUserName, String secondUserName, int cardNum, byte pin) {
        Account bankAccount = new Account(firstUserName, secondUserName, cardNum, pin);
        bankAccount.setBalance(new BigDecimal(0));
        bankAccounts.add(bankAccount);
    }

    //    print Accounts
//    public void printAccounts() {
//        for (Account acc : bankAccounts) {
//            System.out.println("-----------------------------------");
//            System.out.print("Name: " + acc.getFirstUserName() + " ");
//            System.out.println(acc.getSecondUserName());
//            System.out.println("Card number: " + acc.getCardNum());
//            System.out.println("Pin code: " + acc.getPin());
//            System.out.println("Balance: $" + acc.getBalance());
//            System.out.println("-----------------------------------");
//        }
//    }

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

    public Account incomeBalance(BigDecimal income, Account userAccount) {
        BigDecimal newBalance;
        newBalance = userAccount.getBalance();
        userAccount.setBalance(newBalance.add(income));
        return userAccount;
    }

    public Optional<Account> stealBalance(BigDecimal steal, Account userAccount) {
        BigDecimal newBalance;
        newBalance = userAccount.getBalance();
        if (newBalance.compareTo(steal) < 0 ) {
            //System.out.println("Operation denied, low balance");
            return Optional.empty();
        }
        userAccount.setBalance(newBalance.subtract(steal));
        return Optional.of(userAccount);
    }

    public Optional<Account> transferAccount(int cardNumber, BigDecimal money, Account userAccount) {
        Account clientAccount = null;

        for (Account acc : bankAccounts) {
            if (acc.getCardNum() == cardNumber) {
                clientAccount = acc;
            }
        }

        if (clientAccount == null) {
            return Optional.empty();
        }

        BigDecimal clientBalance = clientAccount.getBalance();
        BigDecimal newBalance = userAccount.getBalance();

        if (newBalance.compareTo(money) < 0) {
//            System.out.println("Operation denied, low balance");
            return Optional.empty();
        }

        userAccount.setBalance(newBalance.subtract(money));
        clientAccount.setBalance(clientBalance.add(money));
        System.out.println("Transfer complete!");
        System.out.println("You have " + userAccount.getBalance());
        return Optional.of(userAccount);
    }
}
