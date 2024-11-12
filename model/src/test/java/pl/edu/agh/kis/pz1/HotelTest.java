package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void retAnythingTest(){
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        System.out.println(hotel);
        assertNotNull(hotel);
    }

}