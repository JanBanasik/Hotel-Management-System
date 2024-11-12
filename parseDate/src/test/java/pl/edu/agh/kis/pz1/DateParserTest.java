package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void convert() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        assertEquals(DateParser.convert(""), LocalDate.parse(LocalDate.now().format(formatter), formatter));
        long daysBetween = ChronoUnit.DAYS.between(DateParser.convert(""), DateParser.convert(""));
        assertEquals(0, daysBetween);
    }
}