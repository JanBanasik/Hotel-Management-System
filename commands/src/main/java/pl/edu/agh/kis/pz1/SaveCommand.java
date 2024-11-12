package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * A command that saves the current state of the {@link Hotel} into a CSV file.
 * The saved file includes all room details, such as room number, description, price,
 * main guest, additional guests, check-in date, capacity, and duration of stay.
 */
public class SaveCommand extends Command {

    /**
     * Executes the save command, which prompts the user for a filename and writes the
     * hotel's current state to a CSV file in the specified location.
     *
     * @param hotel the {@link Hotel} object whose state is to be saved
     */
    @Override
    public void execute(Hotel hotel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku, do ktorego chcesz zapisac aktualny stan: ");
        String filename = sc.nextLine();
        String filepath = "./" + filename + ".csv";

        try (
                Writer out = new FileWriter(filepath);
                CSVPrinter csvPrinter = new CSVPrinter(out,
                        CSVFormat.DEFAULT.builder()
                                .setQuoteMode(QuoteMode.MINIMAL)
                                .setHeader("nr_pokoju", "opis", "cena", "GoscGlowny", "DodatkowiGoscie",
                                        "DataZameldowania", "Pojemnosc", "CzasTrwaniaPobytu").build())
        ) {
            for (String key : hotel.rooms.keys()) {
                csvPrinter.printRecord(
                        key,
                        hotel.get(key).opis,
                        hotel.get(key).cena,
                        hotel.get(key).goscGlowny,
                        hotel.get(key).goscieDodatkowi,
                        hotel.get(key).dataZameldowania,
                        hotel.get(key).pojemnosc,
                        hotel.get(key).czasTrwaniaPobytu
                );
            }
        } catch (IOException e) {
            System.out.println("Nie udalo sie zapisac do pliku!");
        }
    }
}
