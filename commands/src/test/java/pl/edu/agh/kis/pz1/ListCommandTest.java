package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ListCommandTest {

    @Test
    void execute() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\testowyd.csv";

        Hotel hotel = new Hotel(filePath);
        ListCommand command = new ListCommand();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setOut(ps);

        command.execute(hotel);


        String output = baos.toString();


        System.out.println("Przechwycone dane:");
        System.out.println(output);

        System.out.println("Wynik hotel.toString():");
        System.out.println(hotel.toString());

        assertEquals("Room101Opis:VIPCena:100Goscglowny:JohnSmithGosciedodatkowi:SarahSmithDatazameldowania:2024-11-10Pojemnosc:4Czastrwaniapobytu:4Planowanadatawyjazdu:2024-11-14", output.replaceAll("\\s+", ""));

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}