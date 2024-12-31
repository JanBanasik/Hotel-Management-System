package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckinCheckoutCommandTest {
    void provideInput(String data){
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void test1() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        provideInput("101");
        CheckoutCommand checkout = new CheckoutCommand();
        checkout.execute(hotel);
        provideInput("101\nJohn Smith\n\n14.11.2024\n5\n");
        CheckinCommand checkin = new CheckinCommand();
        checkin.execute(hotel);
        assertEquals("John Smith", hotel.get("101").goscGlowny);
    }

    @Test
    void testBadCheckin() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);

        CheckinCommand checkin = new CheckinCommand();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);


        provideInput("-5\n");

        System.setOut(ps);
        checkin.execute(hotel);
        String output = baos.toString();

        System.out.println(output);

        System.out.println("Przechwycone dane:");
        assertEquals("Enterroomnumber:Invalidroomnumber!", output.replaceAll("\\s+", ""));

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    void testBadCheckin2() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);

        CheckinCommand checkin = new CheckinCommand();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);


        provideInput("101\n");

        System.setOut(ps);
        checkin.execute(hotel);
        String output = baos.toString();

        System.out.println(output);

        System.out.println("Przechwycone dane:");
        assertEquals("Enterroomnumber:Thisroomisalreadyoccupiedby:JohnSmith", output.replaceAll("\\s+", ""));

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}