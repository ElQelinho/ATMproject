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

        System.out.println("Welcome! It is " + bank.printBankName());
        System.out.println("Let's begin the autorization");

        BufferedReader enterReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print("Please, enter the card number: ");
            int enterCard = Integer.parseInt(enterReader.readLine());

            // FIXME способ выхода их цикла путем ввода "заведомо невалидных" данных это "design flaw"
            //  пользователь банкомата должен иметь более очевидный способ. Тем более, что текущий способ сообщается ему
            //  только после того, как он провалит авторизацию, до этого, пользователь не имеет возможности узнать,
            //  как ему завершить работу.
            //  0000 - это 0, почему коде такая проверка, на что был расчет? Если пользователь введет "0" это условие тоже сработает.
            if (enterCard == 0000) {
                break;
            }
            System.out.print("Enter the pin: ");
            byte enterPin = Byte.parseByte(enterReader.readLine());

            autorizedUser = bank.autorization(enterCard, enterPin);
            validate = validateUser(autorizedUser);
            if (validate) {
                System.out.println("Welcome " + autorizedUser.firstUserName + " " + autorizedUser.secondUserName);
            } else {
                System.out.println("Wrong card number or pin!");
                System.out.println("For exit input \"0000\" to card number");
                System.out.println("Please, try again.");
            }
        } while(!validate);
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
