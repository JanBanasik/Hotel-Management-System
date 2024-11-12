package pl.edu.agh.kis.pz1;

/**
 * A command that lists the details of all rooms in the {@link Hotel}.
 * This command is used to display a summary of the hotel's rooms, including their
 * current state (e.g., occupancy and guest information).
 */
public class ListCommand extends Command {

    /**
     * Executes the list command, which prints the details of all rooms in the hotel.
     * @param hotel the {@link Hotel} object whose rooms are to be listed
     */
    @Override
    public void execute(Hotel hotel) {
        System.out.println(hotel);
    }
}
