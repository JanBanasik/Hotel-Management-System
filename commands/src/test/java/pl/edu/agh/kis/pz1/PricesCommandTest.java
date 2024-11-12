package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PricesCommandTest {

    @Test
    void execute() {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        PricesCommand command = new PricesCommand();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(baos);

        System.setOut(ps);

        command.execute(hotel);


        String output = baos.toString();

        assertNotNull(output);

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}