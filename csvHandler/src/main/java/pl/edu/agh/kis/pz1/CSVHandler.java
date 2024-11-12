package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.Map;
import pl.edu.agh.kis.pz1.util.MyMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * The {@code CSVHandler} class is responsible for reading data from CSV files
 * and returning the information in a structured format. It is mainly used for
 * parsing room data from a CSV file into a map where the room number is the key
 * and the associated room details are stored in a list.
 * <p>
 * This utility class is designed to handle reading and parsing room information
 * like description, price, guest names, check-in dates, etc., from a CSV file.
 * </p>
 */
public class CSVHandler {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private CSVHandler() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads data from the specified CSV file and returns it as a map. The map
     * has room numbers as keys and lists of room details as values.
     *
     * @param filePath the path to the CSV file to be read
     * @return a map containing room data, where keys are room numbers and values
     *         are lists containing the details of each room
     */
    public static Map<String, ArrayList<String>> readAndReturn(String filePath) {
        Map<String, ArrayList<String>> roomData = new MyMap<>();
        try (
                Reader reader = new FileReader(filePath);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String nrPokoju = csvRecord.get(0);
                ArrayList<String> currRoom = getRoom(csvRecord);
                roomData.put(nrPokoju, currRoom);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the file.");
        }

        return roomData;
    }

    /**
     * Converts a CSVRecord to a list of room details, extracting values like room
     * description, price, guest names, check-in date, capacity, and stay duration.
     *
     * @param csvRecord the CSV record containing the data about a room
     * @return a list containing the details of the room
     */
    private static ArrayList<String> getRoom(CSVRecord csvRecord) {
        String opis = csvRecord.get(1) != null ? csvRecord.get(1) : "";
        String cena = csvRecord.get(2) != null ? csvRecord.get(2) : "";
        String goscGlowny = csvRecord.get(3) != null ? csvRecord.get(3) : "";
        String goscieDodatkowi = csvRecord.get(4) != null ? csvRecord.get(4) : "";
        String dataZameldowania = csvRecord.size() > 5 && csvRecord.get(5) != null ?
                csvRecord.get(5) : "";
        String pojemnosc = csvRecord.get(6);
        String czasTrwaniaPobytu = csvRecord.get(7);

        ArrayList<String> result = new ArrayList<>();
        result.add(opis);
        result.add(cena);
        result.add(goscGlowny);
        result.add(goscieDodatkowi);
        result.add(dataZameldowania);
        result.add(pojemnosc);
        result.add(czasTrwaniaPobytu);

        return result;
    }
}
