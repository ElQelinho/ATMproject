package com.example.menu;

import com.example.Account;

public class MenuContext {
    Account account;

    public void setAccount(Account acc) {
        account = acc;
    }

    public Account getAuthUser() {
        return account;
    }
}
