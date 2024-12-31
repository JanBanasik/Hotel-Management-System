package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaveCommandTest {
    void provideInput(String data){
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
    @Test
    void execute() throws IOException {
        String filePath = "C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv";
        Hotel hotel = new Hotel(filePath);
        provideInput("probamikrofonu123");
        SaveCommand save = new SaveCommand();
        save.execute(hotel);
        String p = "probamikrofonu123.csv";
        File f = new File(p);
        assertTrue(f.exists());

    }
}