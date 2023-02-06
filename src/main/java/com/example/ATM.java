package com.example;


import com.example.menu.*;

import java.math.BigDecimal;


public class ATM {
    private Bank bank;

    public boolean validateUser(Account account) {
        return account != null;
    }

    public String retrieveBankName() {
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

    public void incomeBalance(BigDecimal income, MenuContext userContext) {
        bank.incomeBalance(income, userContext.getAuthUser());
    }

    public void stealBalance(BigDecimal steal, MenuContext userContext) throws Exception {
        Account userAccount = userContext.getAuthUser();
        var returnAccountOpt = bank.stealBalance(steal, userAccount);
        if (returnAccountOpt.isPresent()) {
            userContext.setAccount(returnAccountOpt.get());
        } else {
            String exStr = "Bank failure steal balance, you have " + userAccount.getBalance();
            throw new Exception(exStr);
        }
    }

    public void transferBalance(int cardNumber, BigDecimal money, MenuContext userContext) throws Exception{
        Account userAccount = userContext.getAuthUser();
        var returnAccountOpt = bank.transferAccount(cardNumber, money, userAccount);

        if (returnAccountOpt.isPresent()) {
            userContext.setAccount(returnAccountOpt.get());
        } else {
            String exStr = "Bank failure steal balance, you have " + userAccount.getBalance();
            throw new Exception(exStr);
        }
    }
}