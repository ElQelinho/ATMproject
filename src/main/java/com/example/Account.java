package com.example;

import java.math.BigDecimal;

public class Account {

    Account(String firstUserName, String secondUserName, int cardNum, byte pin) {
        this.firstUserName = firstUserName;
        this.secondUserName = secondUserName;
        this.cardNum = cardNum;
        this.pin = pin;
        balance = BigDecimal.ZERO;
    }

    private String firstUserName;

    private String secondUserName;

    private int cardNum;

    private byte pin;

    private BigDecimal balance;

    public String getFirstUserName() {
        return firstUserName;
    }

    public String getSecondUserName() {
        return secondUserName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getCardNum() {
        return cardNum;
    }

    public byte getPin() {
        return pin;
    }
}
