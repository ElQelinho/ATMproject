package ATMproject;

import java.util.ArrayList;
import java.util.Hashtable;

public class Bank {
//    bank name
  private String bankName = "Black Empire Bank";
//  accounts Array
  ArrayList<Account> bankAccounts = new ArrayList<Account>();
  final Account zeroAccount = new Account("None","None",00,(byte) 00);

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

    public Account Autorization(int card, byte pin){
        for (Account acc : bankAccounts) {
            if ((acc.cardNum == card) & (acc.pin == pin)) {
                return acc;
                }
            }
        return zeroAccount;
        }

}


