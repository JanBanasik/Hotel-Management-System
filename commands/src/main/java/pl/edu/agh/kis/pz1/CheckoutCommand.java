package pl.edu.agh.kis.pz1;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

/**
 * A command class for handling the check-out process in a hotel.
 * This class calculates the cost of the stay based on the room rate
 * and the number of days stayed, and then clears the room details for future use.
 */
public class CheckoutCommand extends Command {

    /**
     * Executes the check-out process for a specified room in the hotel.
     * The method performs the following steps:
     * - Prompts the user to enter a room number.
     * - Validates that the room number exists and is currently occupied.
     * - Calculates the number of days stayed based on the check-in date and the current date.
     * - Computes the total cost based on the room rate and the number of days stayed.
     * - Outputs the details of the stay and the total amount owed.
     * - Resets the room's state to make it available for future guests.
     *
     * @param hotel the {@link Hotel} object containing room details
     */
    @Override
    public void execute(Hotel hotel) {
        Scanner sc = new Scanner(System.in);

        // Prompt for room number
        System.out.print("Enter room number: ");
        String roomNumber = sc.nextLine();

        // Validate room number and occupancy status
        if (!hotel.rooms.contains(roomNumber) || hotel.get(roomNumber).goscGlowny.isEmpty()) {
            System.out.println("Invalid room number!");
        } else {
            // Calculate days stayed
            LocalDate today = LocalDate.now();
            long daysBetween = ChronoUnit.DAYS.between(hotel.get(roomNumber).dataZameldowania, today);

            // Output stay details
            System.out.println("You spent: " + Math.max(daysBetween, 0) + " days");
            System.out.println("You owe us: " + Math.max(Integer.parseInt(hotel.get(roomNumber).cena) * daysBetween, 0) + "$");

            // Reset room details
            hotel.rooms.put(roomNumber, new Room(
                    hotel.get(roomNumber).opis,
                    hotel.get(roomNumber).cena,
                    "",
                    "",
                    null,
                    hotel.get(roomNumber).pojemnosc,
                    ""
            ));
        }
    }
}
