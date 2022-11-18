package ATMproject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATM {
    public static void main(String[] args) throws IOException  {


        Bank bank = new Bank();
        Date date = new Date();
        SimpleDateFormat sdate = new SimpleDateFormat("HH:MM:ss dd/MM/yy");


        bank.createAccount("Lora", "Palmer", 2024, (byte) 7);
        bank.createAccount("Max", "Frolov", 2010, (byte) 92);
        bank.createAccount("Gorby", "Jason", 2034, (byte) 15);

        mainMenu(bank,sdate,date);

    }
//Validate user
    private static boolean ValidateUser(Account autorizedUser, Account zeroAccount,SimpleDateFormat sdate,Date date) {
        boolean autorization = false;
        if (autorizedUser != zeroAccount) {
            System.out.println();
//            System.out.println("Welcome " + autorizedUser.firstUserName + " " +autorizedUser.secondUserName);
//            System.out.println("Today is " + sdate.format(date));
            autorization = true;
            return autorization;
        } else {
            System.out.println();
//            System.out.println("Wrong card number or pin!");
//            System.out.println("Please, try again.");

            return autorization;
        }

    }
//    ATM menu
    private static void mainMenu(Bank bank,SimpleDateFormat sdate,Date date) throws IOException{
        boolean validate = false;
        Account autorizedUser;
        System.out.println("Welcome! It is " + bank.printBankName());
        System.out.println("Let's begin the autorization");

        BufferedReader enterReader = new BufferedReader(new InputStreamReader (System.in));

        do {
            System.out.print("Please, enter the card number: ");
            int enterCard = Integer.parseInt(enterReader.readLine());
            if (enterCard == 0000) {
                break;
            }
            System.out.print("Enter the pin: ");
            byte enterPin = Byte.parseByte(enterReader.readLine());

            autorizedUser = bank.Autorization(enterCard,enterPin);
            validate = ValidateUser(autorizedUser, bank.zeroAccount,sdate,date);
            if (validate) {
                System.out.println("Welcome " + autorizedUser.firstUserName + " " +autorizedUser.secondUserName);
            } else {
                System.out.println("Wrong card number or pin!");
                System.out.println("For exit input \"0000\" to card number");
                System.out.println("Please, try again.");
            }

        } while (validate == false);
    }
}
