package com.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATM {
    Bank bank;

    private static boolean validateUser(Account autorizedUser) {
        return autorizedUser != null;
    }

    public void mainMenu(Bank bank) throws IOException {
        int menuChoice;
        System.out.println();
        System.out.println("Welcome! It is " + bank.printBankName());

        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter a number to choose your option:");
        System.out.println("Press 1 for autorization.");
        System.out.println("Press 2 for exit.");
        System.out.print("Enter: ");
        menuChoice = Integer.parseInt(enterReader.readLine());

        switch (menuChoice) {
            case 1:
                autorizingUser(enterReader);
                break;
            case 2:
                break;

        }
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    private void autorizingUser(BufferedReader enterReader) throws IOException {

        int enterCardNumber;
        byte enterPin;
        Account acc;
        do {
            System.out.println();
            System.out.println("This is autorization menu. For exit to main menu enter 1 to card number.");

            System.out.print("Please enter the cardnumber: ");
            enterCardNumber = Integer.parseInt(enterReader.readLine());
            if (enterCardNumber == 1) {
                mainMenu(bank);
                break;
            }
            System.out.print("Please enter the pin: ");
            enterPin = Byte.parseByte(enterReader.readLine());
            acc = bank.autorization(enterCardNumber,enterPin);
            if (validateUser(acc)) {
                userMenu(acc, enterReader);
            } else {
                System.out.println("Wrong card number or pin");
            }
        } while (true);
    }
    private void userMenu(Account acc,BufferedReader enterReader) throws IOException {
        int chooseMenu;
        SimpleDateFormat sdate = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        Date date = new Date();
        do {
            System.out.println();
            System.out.println("Hello, " + acc.firstUserName + " " + acc.secondUserName);
            System.out.println("Today is " + sdate.format(date));
            System.out.println("Enter a number to choose your option: ");
            System.out.println("Press 1 for view your balance.");
            System.out.println("Press 2 for transaction");
            System.out.println("Press 3 for exit to main menu");
            System.out.print("Enter: ");
            chooseMenu = Integer.parseInt(enterReader.readLine());
            switch (chooseMenu) {
                case 1:
                    System.out.println("You have: $" + acc.balance);
                    break;
                case 2:
//                transaction
//                    break;
                case 3:
                    mainMenu(bank);
                    break;
            }
        } while (true);
    }
}

