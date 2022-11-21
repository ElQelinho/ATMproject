package com.example;

import java.util.ArrayList;
import java.util.Hashtable;

// FIXME отформатировать отступы
public class Bank {
//    bank name
  private String bankName = "Black Empire Bank";
//  accounts Array
  ArrayList<Account> bankAccounts = new ArrayList<Account>();

  // FIXME необходимость использования zeroAccount нужно устранить, поле zeroAccount удалить. Ибо это костыль.
  final Account zeroAccount = new Account("None","None",00,(byte) 00);

    // FIXME этот метод используется для "инициализации" банка. Это личное дело банка, метод не должен вызываться в других классах
    //  его вызов следует поместить в конструктор и сделать private.
//create Account
    public ArrayList<Account> createAccount(String firstUserName,String secondUserName, int cardNum,byte pin) {
        Account bankAccount =new Account(firstUserName,secondUserName,cardNum,pin);
        bankAccounts.add(bankAccount);
        return bankAccounts;
    }




//    print Accounts
    public void printAccounts() {
        for (Account acc: bankAccounts) {
            System.out.println("-----------------------------------");
            System.out.print("Name: " + acc.firstUserName + " ");
            System.out.println(acc.secondUserName);
            System.out.println("Card number: " + acc.cardNum);
            System.out.println("Pin code: " + acc.pin);
            System.out.println("Cash: $" + acc.balance);
            System.out.println("-----------------------------------");
        }
    }

    //    printBankName
    public String printBankName() {
        return bankName;
    }

    // FIXME имя метода должно начинаться с малеькой буквы.
    //  Отформатировать код, поправить отступы.
    //  Если авторизация не прошла не нужно возвращать zeroAccount, нужно возвращать null или кидать exception.
    public Account Autorization(int card, byte pin){
        for (Account acc : bankAccounts) {

            // FIXME здесь опечатка, используется побитовый оператор "и", а должен использоваться логический "и".
            if ((acc.cardNum == card) & (acc.pin == pin)) {
                return acc;
                }
            }
        return zeroAccount;
        }

}


