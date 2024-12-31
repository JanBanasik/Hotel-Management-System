package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void retAnythingTest() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        System.out.println(hotel);
        assertNotNull(hotel);
    }

    @Test
    void getTest() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        assertEquals("John Smith", hotel.get("101").goscGlowny);
    }


}