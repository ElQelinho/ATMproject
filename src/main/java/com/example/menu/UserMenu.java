package com.example.menu;

import com.example.ATM;
import com.example.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class UserMenu implements Menu {

    private final Account userAccount;
    MenuContext userContext;

    int chooseOption;
    UserMenu(MenuContext menuContext) {
        userAccount = menuContext.getAuthUser();
        this.userContext = menuContext;
    }
    @Override
    public Menu processMenu(ATM atm) {
        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal income;
        BigDecimal steal;
        BigDecimal transferMoney;
        int transferCard;

        System.out.println();
        System.out.println("Welcome "+ userAccount.getFirstUserName());
        System.out.println("Choose option.");
        System.out.println("1.Balance");
        System.out.println("2.Income");
        System.out.println("3.Withdraw");
        System.out.println("4.Transfer");
        System.out.println("5.Back");

        try {
            System.out.print("Please enter your option: ");
            chooseOption = Integer.parseInt(enterReader.readLine());
            System.out.println();

            switch (chooseOption) {
                case 1:
                    System.out.println("Your balance is $" + userAccount.getBalance());
                    return new UserMenu(userContext);
                case 2:
                    System.out.print("Enter money: ");
                    income = new BigDecimal(enterReader.readLine());
                    atm.incomeBalance(income,userContext);
                    return new UserMenu(userContext);
                case 3:
                    System.out.print("Balance to money: ");
                    steal = new BigDecimal(enterReader.readLine());
                    atm.stealBalance(steal,userContext);
                    return new UserMenu(userContext);
                case 4:
                    System.out.print("Enter a client cardnumber: ");
                    transferCard = Integer.parseInt(enterReader.readLine());
                    System.out.print("Enter a balance for transfer: ");
                    transferMoney = new BigDecimal(enterReader.readLine());
                    atm.transferBalance(transferCard,transferMoney,userContext);
                    return new UserMenu(userContext);
                case 5:
                    return new MainMenu();
                default:
                    String errorMessage = "Wrong value";
                    new ErrorMenu(errorMessage, ()->new UserMenu(userContext));
            }
        } catch (Exception exception) {
            String errorMessage = exception.getMessage();
            return new ErrorMenu(errorMessage, () -> new UserMenu(userContext));
        }
        return new Exit();
    }
}
