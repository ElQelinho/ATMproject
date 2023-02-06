package com.example.menu;

import com.example.ATM;

import java.util.function.Supplier;

public class ErrorMenu implements Menu {

    private final Supplier<? extends Menu> sup;
    private final String errorMessage;

    public ErrorMenu(String errorMessage, Supplier<? extends Menu> sup) {
        this.errorMessage = errorMessage;
        this.sup = sup;
    }

    @Override
    public Menu processMenu(ATM atm) {
        System.out.println(errorMessage);
        return sup.get();
    }
}
