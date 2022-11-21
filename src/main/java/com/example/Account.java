package com.example;

import java.math.BigDecimal;

public class Account {

    Account(String firstUserName,String secondUserName, int cardNum, byte pin) {
        this.firstUserName = firstUserName;
        this.secondUserName = secondUserName;
        this.cardNum = cardNum;
        this.pin = pin;
        balance = BigDecimal.ZERO;
    }

    String firstUserName;

    String secondUserName;

    int cardNum;

    byte pin;

    BigDecimal balance;
}
