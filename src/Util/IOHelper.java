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
     * Prompts the user to input a double value and validates the input.
     *
     * <p>This method repeatedly prompts the user with the provided message until a valid double
     * value is entered. The input is read from the keyboard and validated using a helper method.
     * If the input cannot be parsed as a double, the user is prompted again.
     * </p>
     *
     * @param prompt the message displayed to the user to request input
     * @return the valid double value entered by the user
     * @author Ildar Sadykov
     * @author Diane Mathew (dmm7029@psu.edu)
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
