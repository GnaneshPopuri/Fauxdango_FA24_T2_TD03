package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

// TODO: Create a JavaDoc for the ValidationHelper class
/**
 * A utility class providing various methods for validating input values and performing
 * type conversions. This class includes methods for parsing strings to numeric types,
 * checking character and integer ranges, and validating strings against specific criteria.
 *
 *@author Ildar Sadykov
 *@author Diane Mathew (dmm7029@psu.edu)
 */
public class ValidationHelper {
    private final static Logger logger = LogManager.getRootLogger();

    // Regex patterns
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-z]+$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    public static Double tryParseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (Exception e) {
            logger.debug("Invalid input: " + text);
            return null;
        }
    }

    public static Integer tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            logger.debug("Invalid input: " + text);
            return null;
        }
    }

    /**
     * Validate a given character is in range
     * <p>
     * Determine if the given character is in an allowed range
     *
     * @param ch    The character being validated
     * @param range The string holding valid characters
     * @return true if the character is in range
     */
    public static boolean isCharInRange(char ch, String range) {
        if (range == null) {
            return false;
        }
        return (range.indexOf(ch) >= 0);
    }

    /**
     * Checks that given string is "Y" or "N"
     *
     * @param str string to be checked
     * @return true if string is "Y" or "N"
     */
    public static boolean isValidYorN(String str) {
        return ("N".equals(str) || "Y".equals(str));
    }

    // TODO: Create a JavaDoc for isIntInRange method
    /**
     * Validates whether an integer is within a specified range.
     *
     * @param value the integer value to validate
     * @param start the inclusive start of the range
     * @param end   the inclusive end of the range
     * @return {@code true} if the value is within the range, otherwise {@code false}
     * @author Ildar Sadykov
     * @author Diane Mathew (dmm7029@psu.edu)
     */
    public static boolean isIntInRange(int value, int start, int end) {
        if (value < start || value > end) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isStringNullOrEmpty(String str) {
        return ((str == null) || (str.isEmpty()));
    }

    /**
     * Validates that a given name starts with a capital letter followed by lowercase letters.
     *
     * @param name the name to validate
     * @return true if the name is valid, false otherwise
     */
    public static boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            logger.debug("Invalid name: " + name);
            return false;
        }
        boolean matches = NAME_PATTERN.matcher(name).matches();
        if (!matches) {
            logger.debug("Name does not match the pattern: " + name);
        }
        return matches;
    }

    /**
     * Validates that a given email address is in a proper format.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            logger.debug("Invalid email: " + email);
            return false;
        }
        boolean matches = EMAIL_PATTERN.matcher(email).matches();
        if (!matches) {
            logger.debug("Email does not match the pattern: " + email);
        }
        return matches;
    }
}
