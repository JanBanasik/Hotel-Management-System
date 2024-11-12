package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.Map;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CSVHandlerTest{
    @Test
    void returnsAnything(){
        Map<String, ArrayList<String>> r;
        r = CSVHandler.readAndReturn("C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv");
        assertNotNull(r);
    }
    @Test
    void getValues(){
        Map<String, ArrayList<String>> r;
        r = CSVHandler.readAndReturn("C:\\Users\\jan_b\\OneDrive\\Pulpit\\Zadanie1PZ1\\multi-module\\data.csv");
        for(String key: r.keys()){
            System.out.println(r.get(key));
        }
        assertNotNull(r);
    }
}
