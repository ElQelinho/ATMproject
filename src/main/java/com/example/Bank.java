package com.example;

import java.util.ArrayList;

public class Bank {
    //    bank name
    private String bankName = "Black Empire Bank";
    //  accounts Array
    ArrayList<Account> bankAccounts = new ArrayList<Account>();

    // FIXME этот метод используется для "инициализации" банка. Это личное дело банка, метод не должен вызываться в других классах
    //  его вызов следует поместить в конструктор и сделать private.
//    Не согласен. Этот метод используется для создания аккаунта и помещения его в список аккаунтов.
//    У банкомата должна быть возможность вызова этого метода.
//    Иначе, будет создано много экземпляров банка, для создания аккаунта. А банк один.
//create Account
    public ArrayList<Account> createAccount(String firstUserName, String secondUserName, int cardNum, byte pin) {
        Account bankAccount = new Account(firstUserName, secondUserName, cardNum, pin);
        bankAccounts.add(bankAccount);
        return bankAccounts;
    }

    //    print Accounts
    public void printAccounts() {
        for (Account acc : bankAccounts) {
            System.out.println("-----------------------------------");
            System.out.print("Name: " + acc.firstUserName + " ");
            System.out.println(acc.secondUserName);
            System.out.println("Card number: " + acc.cardNum);
            System.out.println("Pin code: " + acc.pin);
            System.out.println("Cash: $" + acc.balance);
            System.out.println("-----------------------------------");
        }
    }

    //    printBankName
    public String printBankName() {
        return bankName;
    }

    public Account autorization(int card, byte pin) {
        for (Account acc : bankAccounts) {
            if ((acc.cardNum == card) && (acc.pin == pin)) {
                return acc;
            }
        }
        return null;
    }

}


