package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.Map;
import pl.edu.agh.kis.pz1.util.MyMap;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code Hotel} class represents a hotel, storing rooms and providing methods for managing them.
 * This class allows for loading room data from a CSV file, accessing individual rooms, and getting
 * a textual representation of the hotel's room information.
 */
public class Hotel {

    /**
     * A map of rooms in the hotel, where the key is the room number and the value is a {@link Room} object.
     */
    Map<String, Room> rooms = new MyMap<>();

    /**
     * Constructor for creating a hotel using room data from a CSV file.
     * The room data is loaded and then stored in a map where room numbers are keys.
     *
     * @param filePath the path to the CSV file containing the room data
     */
    public Hotel(String filePath) throws IOException {
        Map<String, ArrayList<String>> temp;
        temp = CSVHandler.readAndReturn(filePath);
        for (String key : temp.keys()) {
            Room currRoom = new Room(
                    temp.get(key).get(0), temp.get(key).get(1),
                    temp.get(key).get(2), temp.get(key).get(3),
                    (temp.get(key).get(2).isEmpty() ? null : DateParser.convert(temp.get(key).get(4))),
                    temp.get(key).get(5),
                    temp.get(key).get(6)
            );
            rooms.put(key, currRoom);
        }
    }

    /**
     * Retrieves a room from the hotel by its room number.
     *
     * @param key the room number to fetch
     * @return the {@link Room} object associated with the given room number
     */
    public Room get(String key) {
        return rooms.get(key);
    }

    /**
     * Returns a textual representation of all rooms in the hotel, including their details.
     *
     * @return a string representing all rooms in the hotel
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String key : rooms.keys()) {
            res.append("Room ").append(key).append("\n").append(rooms.get(key)).append("\n");
        }
        return res.toString();
    }
}
