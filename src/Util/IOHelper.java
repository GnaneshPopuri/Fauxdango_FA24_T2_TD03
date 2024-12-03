package Util;

import Model.Console;

import java.util.Scanner;

public class IOHelper {
    private static final Scanner keyboard = Console.keyboard;

    public static String readStringFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");

        return keyboard.nextLine();
    }

    public static String readNonBlankStringFromKeyboard(String prompt) {
        String nonblankString;

        while (true) {
            nonblankString = readStringFromKeyboard(prompt);
            if (nonblankString.trim().isEmpty()) {
                System.out.println();
                System.out.println("Cannot be blank");
            } else {
                break;
            }
        }

        return nonblankString;
    }
}
