package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.Map;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * The main entry point for the hotel management application.
 * This class provides a command-line interface for interacting with a hotel object.
 * The user can input commands that are executed on the hotel, and the program will continue until the "exit" command is entered.
 * The commands are dynamically retrieved from a dictionary and executed accordingly.
 */
public class Main {

    /**
     * Main method to start the application. It initializes the hotel system,
     * retrieves user input, and executes corresponding commands until the "exit" command is entered.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws InvocationTargetException If there is an exception thrown by the invoked method.
     * @throws NoSuchMethodException If the method for a given command is not found.
     * @throws InstantiationException If the command cannot be instantiated.
     * @throws IllegalAccessException If access to the command method is illegal.
     */
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // Retrieve the dictionary of available commands.
        Map<String, Command> commands = CommandDictionary.getCommandDictionary();

        // Initialize the scanner for reading user input.
        Scanner sc = new Scanner(System.in);

        // Prompt for the file path and create the Hotel object.
        System.out.println("Enter filePath: ");
        String filePath = sc.nextLine();
        Hotel hotel = new Hotel(filePath);

        // Main loop for handling user commands.
        while (true) {
            // Prompt for a command from the user.
            System.out.print("\n$Enter command: ");
            String c = sc.nextLine();
            System.out.println();

            // Check if the command is "exit" and break the loop if true.
            if (c.equals("exit")) {
                System.out.println("Executing command: " + c);
                break;
            }

            // Check if the command exists in the dictionary.
            if (!commands.contains(c)) {
                // Print an error message if the command is invalid.
                System.out.println("Invalid command!");
            } else {
                // Print the command and execute it on the hotel object.
                System.out.println("Executing command: " + c);
                commands.get(c).execute(hotel);
            }
        }
    }
}
