package Util;

import Model.Console;

import java.util.Scanner;

public class IOHelper {
    private static final Scanner keyboard = Console.keyboard;

    private static IOHelper instance;

    private IOHelper() {}

    public static IOHelper getInstance() {
        if (instance == null) {
            instance = new IOHelper();
        }
        return instance;
    }

    public String readStringFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");
        return keyboard.nextLine();
    }
}
