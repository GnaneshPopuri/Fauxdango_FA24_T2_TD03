package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

}