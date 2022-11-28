package com.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATM {
    public void begin() throws IOException {

        Bank bank= new Bank();

        Date date = new Date();
        SimpleDateFormat sdate = new SimpleDateFormat("HH:MM:ss dd/MM/yy");


        bank.createAccount("Lora", "Palmer", 2024, (byte) 7);
        bank.createAccount("Max", "Frolov", 2010, (byte) 92);
        bank.createAccount("Gorby", "Jason", 2034, (byte) 15);

        this.mainMenu(bank, sdate, date);
    }

    // FIXME не информативный комментарий надо удалить.
    //  имя метода должно начинаться с маленькой буквы.
    //  Отформатировать список формальных параметров.
//Validate user
    private static boolean validateUser(Account autorizedUser, SimpleDateFormat sdate, Date date) {
        if (autorizedUser != null) {
            System.out.println();
//            System.out.println("Welcome " + autorizedUser.firstUserName + " " +autorizedUser.secondUserName);
//            System.out.println("Today is " + sdate.format(date));
            return true;
        } else {
            System.out.println();
//            System.out.println("Wrong card number or pin!");
//            System.out.println("Please, try again.");

            return false;
        }

    }

    private void mainMenu(Bank bank, SimpleDateFormat sdate, Date date) throws IOException {
        boolean validate = false;
        Account autorizedUser;
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
            validate = validateUser(autorizedUser, sdate, date);
            if (validate) {
                System.out.println("Welcome " + autorizedUser.firstUserName + " " + autorizedUser.secondUserName);
            } else {
                System.out.println("Wrong card number or pin!");
                System.out.println("For exit input \"0000\" to card number");
                System.out.println("Please, try again.");
            }
        } while (!validate);
    }
}
