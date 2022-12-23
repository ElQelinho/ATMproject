package com.example.menu;

import com.example.ATM;
import com.example.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Auth implements Menu {

    @Override
    public Menu processMenu(ATM atm) {
        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));
        int enterCardNumber;
        byte enterPin;
        Account userAccount;
        String exitChoose;

        System.out.println();
        System.out.println("This is authorization menu.");


        try {
            System.out.print("Please enter the cardnumber: ");
            enterCardNumber = Integer.parseInt(enterReader.readLine());
        } catch (IOException exception) {
            String errorMessage = "";
            return new Error(errorMessage, () -> new Auth());
        }

        try {
            System.out.print("Please enter the pin: ");
            enterPin = Byte.parseByte(enterReader.readLine());
        } catch (IOException exception) {
            String errorMessage = "";
            return new Error(errorMessage, () -> new Auth());
        }

        userAccount = atm.getAccount(enterCardNumber, enterPin);
        if (atm.validateUser(userAccount)) {
            MenuContext menuContext = new MenuContext();
            menuContext.setAccount(userAccount);
            return new UserMenu(menuContext);
        } else {
            System.out.println("Wrong Card Number or pin.");
            System.out.println("Do you want to try again? (y/N):");

            try {
                exitChoose = enterReader.readLine();
            } catch (IOException exception) {
                String errorMessage = "";
                return new Error(errorMessage, () -> new Auth());
            }

            if (exitChoose.equals("y")) {
                return  new Auth();
            } else if (exitChoose.equals("N")){
                return new Exit();
            } else {
                String errorMessage = "Wrong argument";
                return new Error(errorMessage, () -> new Auth());
            }

        }
    }
}
