package pl.edu.agh.kis.pz1;

/**
 * A command that displays the daily prices for all rooms in the {@link Hotel}.
 * This command is used to provide an overview of the cost of staying in each room.
 */
public class PricesCommand extends Command {

    /**
     * Executes the prices command, which prints the daily rates for each room in the hotel.
     *
     * @param hotel the {@link Hotel} object containing the room information and prices
     */
    @Override
    public void execute(Hotel hotel) {
        for (String key : hotel.rooms.keys()) {
            System.out.println("Pokoj " + key + " -> cena za dobe: " + hotel.get(key).cena + "$");
        }
    }
}
