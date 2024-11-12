package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.FileDescriptor;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ListCommandTest {

    @Test
    void execute() {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";

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

        assertEquals(output.replaceAll("\\s+", ""), hotel.toString().replaceAll("\\s+", ""));

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}