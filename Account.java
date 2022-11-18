package ATMproject;

public class Account {

    Account(String firstUserName,String secondUserName, int cardNum, byte pin) {
        this.firstUserName = firstUserName;
        this.secondUserName = secondUserName;
        this.cardNum = cardNum;
        this.pin = pin;
        balance = 0;
    }

//   first user name
    String firstUserName;
//    second user name
    String secondUserName;
//    card number;
    int cardNum;
//    pin
    byte pin;
//    cash
    float balance;

}
