package pl.edu.agh.kis.pz1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The {@code DateParser} class is a utility class for parsing date strings into {@link LocalDate} objects.
 * It provides a method to convert a date in the textual format (dd.MM.yyyy) to a {@link LocalDate} object.
 * If the input string is empty or has an incorrect format, the current date is returned.
 */
public class DateParser {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private DateParser() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Converts a date string in the format "dd.MM.yyyy" to a {@link LocalDate} object.
     * If the input string is empty or has an incorrect format, the current date is returned.
     *
     * @param dataZameldowania The date string in the format "dd.MM.yyyy".
     * @return A {@link LocalDate} object representing the check-in date.
     *         If the input string is empty or invalid, the current date is returned.
     */
    public static LocalDate convert(String dataZameldowania) {
        // If the input string is empty, return the current date
        if(dataZameldowania.isEmpty()){
            return LocalDate.now();
        }

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Initialize the result with the current date as the default
        LocalDate res;

        try {
            // Convert the string to a LocalDate object
            res = LocalDate.parse(dataZameldowania, formatter);
        } catch (DateTimeParseException e) {
            // If the format is incorrect, return the current date
            res = LocalDate.now();
        }

        return res;
    }
}
