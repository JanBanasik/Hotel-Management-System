package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;
import pl.edu.agh.kis.pz1.util.Map;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class CommandDictionaryTest {

    @Test
    void getCommandDictionary() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<String, Command> d = CommandDictionary.getCommandDictionary();
        assertNotNull(d);
        assertTrue(d.contains("checkin"));
        assertTrue(d.contains("checkout"));
        assertTrue(d.contains("list"));
        assertTrue(d.contains("prices"));
        assertTrue(d.contains("save"));
        assertTrue(d.contains("view"));
    }
}