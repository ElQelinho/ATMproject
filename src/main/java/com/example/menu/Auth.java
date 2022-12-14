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
            Account acc;

                System.out.println();
                System.out.println("This is authorization menu. For exit to main menu enter 1 to card number.");

                System.out.print("Please enter the cardnumber: ");
                try {
                    enterCardNumber = Integer.parseInt(enterReader.readLine());
                } catch (IOException exception) {
                    String errorMessage = "";
                    return new Error(errorMessage, ()->new Auth());
                }
                if (enterCardNumber == 1) {
                    return new Exit();
                }
                System.out.print("Please enter the pin: "); try {
                    enterPin = Byte.parseByte(enterReader.readLine());
                } catch (IOException exception) {
                    String errorMessage = "";
                    return new Error(errorMessage, ()->new Auth());
                }

                acc = atm.bank.authorization(enterCardNumber, enterPin);
                if (atm.validateUser(acc)) {
                    return new UserMenu();
                } else {
                    System.out.println("Wrong card number or pin");
                    return new Auth();
                }
        }
    }
