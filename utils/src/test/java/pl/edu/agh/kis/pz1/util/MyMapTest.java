package pl.edu.agh.kis.pz1.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    MyMap<Integer, Integer> m1;
    ArrayList<Integer> keys;
    ArrayList<Integer> values;
    Random rand;
    @BeforeEach
    void beforeEach() {
        m1 = new MyMap<>();
        keys = new ArrayList<>();
        values = new ArrayList<>();
        rand = new Random();

        for(int i = 0; i < 3; i ++){
            keys.add(rand.nextInt(100));
            values.add(rand.nextInt(100));
        }
        for(int i = 0; i < 3; i++){
            m1.put(keys.get(i), values.get(i));
        }
    }

    @Test
    void putAndGetIntTest() {
        for (int i = 0; i < 3; i ++) {
            assertEquals(m1.get(keys.get(i)), values.get(i));
        }
    }

    @Test
    void keysTest() {
        assertEquals(m1.keys(), keys);
    }

    @Test
    void removeTest(){
        m1.remove(keys.get(0));
        keys.remove(0);
        assertEquals(m1.keys(), keys);
    }

    @Test
    void containsTest() {
        for(int i = 0; i < 3; i ++){
            assertTrue(m1.contains(keys.get(i)));
        }
    }

    @Test
    void returnsCorrectReferceOfKeys(){
        List<Integer> l1 = m1.keys();
        l1.remove(0);
        assertNotEquals(l1, m1.keys());
    }
    @Test
    void anotherTest(){
        m1.put(1, 3);
        m1.put(1,2);
        assertEquals(2, m1.get(1));
    }

    @Test
    void returnsNullTest(){
        assertNull(m1.get(100000));
    }

    @Test
    void removeNonExistentKeyTest() {
        assertFalse(m1.remove(-50));
    }

    @Test
    void toStringTest() {
        Map<Integer, Integer> mT = new MyMap<>();
        assertEquals(0, mT.toString().length());
    }
}