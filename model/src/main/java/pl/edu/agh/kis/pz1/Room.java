package pl.edu.agh.kis.pz1;

import java.time.LocalDate;

/**
 * The {@code Room} class represents a hotel room, storing information about the room,
 * such as its description, price, guests, check-in date, capacity, and duration of stay.
 */
public class Room {

    /**
     * The description of the room.
     */
    String opis;

    /**
     * The price of the room per night.
     */
    String cena;

    /**
     * The name of the main guest staying in the room.
     */
    String goscGlowny;

    /**
     * The names of additional guests staying in the room.
     */
    String goscieDodatkowi;

    /**
     * The check-in date of the main guest.
     */
    LocalDate dataZameldowania;

    /**
     * The capacity of the room (e.g., the number of people it can accommodate).
     */
    String pojemnosc;

    /**
     * The duration of stay in the room, expressed in days.
     */
    String czasTrwaniaPobytu;

    /**
     * Constructor for creating a room based on input data.
     *
     * @param opis            The description of the room.
     * @param cena            The price of the room.
     * @param goscGlowny      The name of the main guest.
     * @param goscieDodatkowi The names of additional guests.
     * @param dataZameldowania The check-in date of the guests.
     * @param pojemnosc       The capacity of the room (number of people).
     * @param czasTrwaniaPobytu The duration of stay in the room.
     */
    public Room(String opis, String cena, String goscGlowny,
                String goscieDodatkowi, LocalDate dataZameldowania,
                String pojemnosc, String czasTrwaniaPobytu) {
        this.opis = opis;
        this.cena = cena;
        this.goscGlowny = goscGlowny;
        this.goscieDodatkowi = goscieDodatkowi;
        this.dataZameldowania = dataZameldowania;
        this.pojemnosc = pojemnosc;
        this.czasTrwaniaPobytu = czasTrwaniaPobytu;
    }

    /**
     * Returns a string representation of the room, including all its details such as description, price,
     * main and additional guests, check-in date, capacity, and duration of stay.
     *
     * @return a string representing all the details of the room.
     */
    @Override
    public String toString() {
        String res = "";
        res += "Opis: " + opis + "\n";
        res += "Cena: " + cena + "\n" +"$";
        res += "Gosc glowny: " + goscGlowny + "\n";
        res += "Goscie dodatkowi: " + goscieDodatkowi + "\n";
        res += "Data zameldowania: " + (dataZameldowania == null ? "" : dataZameldowania) + "\n";
        res += "Pojemnosc: " + pojemnosc + "\n";
        res += "Czas trwania pobytu: " + (czasTrwaniaPobytu == null ? 0 : czasTrwaniaPobytu) + "\n";
        return res;
    }
}
