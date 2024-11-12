package pl.edu.agh.kis.pz1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class MainTest {


    /**
     * Test for the construction of Main and the 
     * main method being called
     *
     */
    @Test
    void shouldCreateMainObject(){
        Main main = new Main();
        assertNotNull(main, "Main method called.");
    }
}


