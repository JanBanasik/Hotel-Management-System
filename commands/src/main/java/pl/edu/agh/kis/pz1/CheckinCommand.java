package pl.edu.agh.kis.pz1;

import java.util.Scanner;

/**
 * A command class for handling the check-in process in a hotel.
 * This class interacts with the user to gather necessary information
 * about the room, main guest, additional guests, check-in date, and stay duration.
 */
public class CheckinCommand extends Command {

    /**
     * Executes the check-in process for a specified room in the hotel.
     * The method prompts the user for input to:
     * - Specify the room number to be checked in.
     * - Provide the main guest's name.
     * - Optionally add additional guests.
     * - Set the check-in date.
     * - Specify the number of days for the stay.
     * The method performs validation to ensure:
     * - The room number is valid and exists in the hotel.
     * - The room is not already occupied.
     *
     * @param hotel the {@link Hotel} object containing room details
     */
    @Override
    public void execute(Hotel hotel) {
        Scanner sc = new Scanner(System.in);

        // Prompt for room number
        System.out.print("Enter room number: ");
        String roomNumber = sc.nextLine();

        // Validate room number
        System.out.println(hotel.rooms.keys());
        if (!hotel.rooms.contains(roomNumber)) {
            System.out.println("Invalid room number!");
            return;
        } else if (!hotel.get(roomNumber).goscGlowny.isEmpty()) {
            System.out.println("This room is already occupied by: " + hotel.get(roomNumber).goscGlowny);
            return;
        }

        // Get main guest's name
        String goscGlowny;
        do {
            System.out.println("Podaj goscia głownego:");
            goscGlowny = sc.nextLine();
        } while (goscGlowny.isEmpty());

        // Get additional guests
        StringBuilder goscieDodatkowi = new StringBuilder();
        System.out.println("Podaj gosci dodatkowych lub q jezeli chcesz przerwac");
        String temp;
        for (int i = 0; i < Integer.parseInt(hotel.get(roomNumber).pojemnosc) - 1; i++) {
            System.out.println("Podaj goscia dodatkowego: ");
            temp = sc.nextLine();
            if (temp.equals("q") || temp.isEmpty()) break;
            goscieDodatkowi.append(temp).append(" ");
        }

        // Update room details
        hotel.get(roomNumber).goscGlowny = goscGlowny;
        hotel.get(roomNumber).goscieDodatkowi = goscieDodatkowi.toString().trim();

        // Get check-in date
        System.out.println("Podaj date zameldowania (w formacie dd.mm.yyyy):");
        hotel.get(roomNumber).dataZameldowania = DateParser.convert(sc.nextLine());

        // Get stay duration
        System.out.println("Podaj ilosc dni pobytu: ");
        hotel.get(roomNumber).czasTrwaniaPobytu = sc.nextLine();
    }
}
