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

    public static String readStringFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");
        return keyboard.nextLine();
    }
    /**
     * Reads a double from user input.
     *
     * @return the double value entered by the user
     * @throws NumberFormatException if the user enters an invalid double
     * @author Joshua Waldron (Jsw5796@psu.edu)
     */
    public static double userInputDouble(String prompt) {
        Double parsedToDouble = null;

        while (parsedToDouble == null) {
            String userInput = readStringFromKeyboard(prompt);
            parsedToDouble = ValidationHelper.tryParseDouble(userInput);
        }

        return parsedToDouble;
    }

    /**
     * Prompt for user input, and validate in range
     * <p>
     * Repeatedly prompt the user for a character.<p>
     * Ensure that the character is within a range of characters
     * <p>(which is packed into a string)
     *
     * @param prompt Prompt, so the user knows what to type in
     * @param range  Valid characters allowed (e.g., "aeiou")
     * @return In-range character chosen by the user
     */
    public static char userInputChar(String prompt, String range) {

        char userChar = 0;
        while (!ValidationHelper.isCharInRange(userChar, range)) {
            String userInput = readStringFromKeyboard(prompt + " (" + range + ")");
            if (userInput.length() > 0) {
                userChar = userInput.charAt(0);
            }
        }

        return userChar;
    }
}
