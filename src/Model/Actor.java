package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Actor extends DataStoreObj {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Actor(String firstName, String lastName, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = convertToDate(birthday);
    }

    private LocalDate convertToDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthday + ")";
    }
}
