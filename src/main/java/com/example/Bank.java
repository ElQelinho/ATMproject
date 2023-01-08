package com.example;

import java.util.ArrayList;

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

    private ArrayList<Account> createAccount(String firstUserName, String secondUserName, int cardNum, byte pin) {
        Account bankAccount = new Account(firstUserName, secondUserName, cardNum, pin);
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
            System.out.println("Cash: $" + acc.balance);
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
}


