package com.example;


import com.example.menu.Auth;
import com.example.menu.MainMenu;
import com.example.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class ATM {
    public Bank bank;
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
}