package pl.edu.agh.kis.pz1;

import java.util.Scanner;

/**
 * A command that allows the user to view details of a specific room in the {@link Hotel}.
 * The user is prompted to enter the room number, and the details of the room are displayed
 * if the room exists in the hotel. If the room number is invalid, an error message is displayed.
 */
public class ViewCommand extends Command {

    /**
     * Executes the view command, which displays the details of a specific room in the hotel.
     *
     * @param hotel the {@link Hotel} object containing the rooms
     */
    @Override
    public void execute(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter room number: ");
        String roomNumber = sc.nextLine();

        // Check if the room exists
        if (!hotel.rooms.contains(roomNumber)) {
            System.out.println("Invalid room number!");
        } else {
            // Display the room details
            System.out.println(hotel.get(roomNumber));
        }
    }
}
