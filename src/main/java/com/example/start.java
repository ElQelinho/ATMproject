package com.example;
import com.example.ATM;

import java.io.IOException;

public class start {
    public static void main(String[] args) throws IOException {

        ATM atm = new ATM();
        atm.begin();
    }
}
