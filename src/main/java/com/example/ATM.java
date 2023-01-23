package com.example;


import com.example.menu.*;

import java.math.BigDecimal;


public class ATM {
    private Bank bank;
    private MenuContext returnContext;
    Account returnAccount;
    public boolean validateUser(Account autorizedUser) {
        return autorizedUser != null;
    }

    public String retrievBankName() {
        return bank.printBankName();
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void mainMenu() {
        Menu menu  = new MainMenu();
        while (menu != null) {
            menu = menu.processMenu(this);
        }
    }

    public Account getAccount(int cardNumber, byte pin) {
        Account acc;
        acc = bank.fetchAccount(cardNumber, pin);
        if (validateUser(acc)) {
            return acc;
        } else {
            return null;
        }
    }

    public MenuContext incomeBalance(BigDecimal income, MenuContext userContext) {
        returnContext = bank.incomeBalance(income, userContext);
        return returnContext;
    }

    public MenuContext stealBalance(BigDecimal steal, MenuContext userContext) {
        returnContext = bank.stealBalance(steal,userContext);
        return returnContext;
    }

    public MenuContext transferBalance(int cardNumber, BigDecimal money,MenuContext userContext) {
        returnContext = bank.transferAccount(cardNumber,money,userContext);
        return returnContext;
    }
}