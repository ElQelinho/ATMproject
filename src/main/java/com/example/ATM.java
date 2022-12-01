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
        boolean validate = false;
        Account autorizedUser;
        Date date = new Date();
        SimpleDateFormat sdate = new SimpleDateFormat("HH:MM:ss dd/MM/yy");
        int menuChoice;
        System.out.println();
        System.out.println("Welcome! It is " + bank.printBankName());

        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter a num for choose you're option:");
        System.out.println("Press 1 for autorization.");
        System.out.println("Press 2 for exit.");
        System.out.print("Enter: ");
        menuChoice = Integer.parseInt(enterReader.readLine());

        switch (menuChoice) {
            case 1:
                autorizingUser(enterReader);
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
        String checkCardNum;
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
            acc = bank.autorization(enterCardNumber, (byte) enterPin);

            if (validateUser(acc)) {
//                bank.userMenu(acc);
//                break;
            } else {
                System.out.println("Wrong card number or pin");
            }
        } while (true);
    }
}
