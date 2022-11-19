package ATMproject;

// FIXME удалить/изменить комментарии к полям. Сейчас это просто перевод имени полей,
//  они не несут дополнительной информации. А должны нести, например:
//  "// Имя пользователя с большой буквы, если у пользователя несколько имен - его первое имя."
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
    // FIXME остаток по счету следует вести в значении такого, типа, который не будет иметь погрешностей
    //  при выполнении над ним арифметических операций. Тип float не подойдет, потому, что 5.3 + 4.7 != 10.0 из-за
    //  погрешности представления чисел с плавающей точкой в двоичной системе исчисления.
    //  Можно использовать long и вести сумму в копейках, или BigDecimal.
//    cash
    float balance;

}
