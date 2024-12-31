package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewCommandTest {
    void provideInput(String data){
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void execute() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";

        Hotel hotel = new Hotel(filePath);
        ViewCommand command = new ViewCommand();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);


        provideInput("101");
        System.setOut(ps);
        command.execute(hotel);


        String output = baos.toString();


        System.out.println(output);

        System.out.println("Przechwycone dane:");
        assertEquals(output.replaceAll("\\s+", ""), "Enterroomnumber:"+hotel.get("101").toString().replaceAll("\\s+", ""));

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

    }
}