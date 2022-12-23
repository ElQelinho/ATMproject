package com.example.menu;

import com.example.ATM;
import com.example.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserMenu implements Menu {

    Account userAccount;

    UserMenu(MenuContext menuContext) {
        userAccount = menuContext.getAuthUser();
    }

    BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));
    int chooseOption;
    @Override
    public Menu processMenu(ATM atm) {
        System.out.println();
        System.out.println("Welcome "+ userAccount.getFirstUserName());
        System.out.println("Choose option.");
        System.out.println("1.Balance");
        System.out.println("2.Income");
        System.out.println("3.Withdrow");
        System.out.println("4.Transfer");
        System.out.println("5.Exit");

        try {
            System.out.print("Please enter your option: ");
            chooseOption = Integer.parseInt(enterReader.readLine());
        } catch (IOException exception) {
            String errorMessage = "";
            return new Error(errorMessage, () -> new UserMenu(null));
        }

        System.out.println();
        switch (chooseOption) {
            case 1:
                System.out.println("Your balanse is $" + userAccount.getBalance());
            case 5:
                return new Exit();
        }
        return new Exit();
    }
}
