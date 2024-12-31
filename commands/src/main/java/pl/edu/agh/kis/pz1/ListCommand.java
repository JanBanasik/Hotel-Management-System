package pl.edu.agh.kis.pz1;

import java.time.LocalDate;

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
        StringBuilder res = new StringBuilder();
        for (String key : hotel.rooms.keys()) {
            boolean emptyRoom = hotel.get(key).goscGlowny.isEmpty();
            LocalDate newDate = null;
            if (!emptyRoom && hotel.get(key).dataZameldowania != null) {
                LocalDate date = (hotel.get(key)).dataZameldowania;
                String temp = hotel.get(key).czasTrwaniaPobytu;
                newDate = date.plusDays(temp.isEmpty() ? 1 : Integer.parseInt(temp));
            }


            LocalDate dataWyjazdu = (emptyRoom ? null: newDate);
            res.append("Room ").append(key).append("\n").append(hotel.get(key)).append("Planowana data wyjazdu: ").append(dataWyjazdu != null ? dataWyjazdu : "").append("\n").append("\n");
        }
        System.out.println(res);
    }
}
