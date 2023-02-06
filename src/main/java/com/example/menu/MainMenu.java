package com.example.menu;

import com.example.ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu implements Menu {

    @Override
    public Menu processMenu(ATM atm) {
        int menuChoice;
        System.out.println();
        System.out.println("Welcome! It is " + atm.retrieveBankName());

        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a number to choose your option:");
        System.out.println("Press 1 for autorization.");
        System.out.println("Press 2 for exit.");
        System.out.print("Enter: ");

        try {
            menuChoice = Integer.parseInt(enterReader.readLine());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        switch (menuChoice) {
            case 1:
                return new Auth();
            case 2:
                return new Exit();
            default:
                String errorMessage = "Invalid menu number, given " + menuChoice + ", awaited 1 or 2.";
                return new ErrorMenu(errorMessage, MainMenu::new);
        }
    }

}
