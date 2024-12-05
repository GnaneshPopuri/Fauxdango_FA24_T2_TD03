package View.ConsoleDisplay;

import Model.User;
import Util.IOHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDisplay {
    private final static Logger logger = LogManager.getRootLogger();

    public static User registerUser() {
        User user = new User();

        IOHelper ioHelper = IOHelper.getInstance();

        user.setFirstName(ioHelper.readStringFromKeyboard("Enter First Name"));
        user.setLastName(ioHelper.readStringFromKeyboard("Enter Last Name"));
        user.setEmailAddress(ioHelper.readStringFromKeyboard("Enter Email address"));

        logger.info("New user: " + user);

        return user;
    }
}
