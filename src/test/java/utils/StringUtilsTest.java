package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void estEntier() {
        assertTrue(StringUtils.estEntier("-5"), "'-5' doit être un entier");
        assertTrue(StringUtils.estEntier("0"), "'0' doit être un entier");
        assertTrue(StringUtils.estEntier("5"), "'5' doit être un entier");

        assertFalse(StringUtils.estEntier("0.0"), "'0.0' ne doit pas être un entier");
        assertFalse(StringUtils.estEntier("0.0"), "'0,0' ne doit pas être un entier");

        assertFalse(StringUtils.estEntier(""), "'' ne doit pas être un entier");
    }

    @Test
    void nbOccurrence() {
        assertEquals(0, StringUtils.nbOccurrence("", 'a'), "Il doit y avoir 0 'a' dans ''");
        assertEquals(0, StringUtils.nbOccurrence("b", 'a'), "Il doit y avoir 0 'a' dans 'b'");
        assertEquals(1, StringUtils.nbOccurrence("a", 'a'), "Il doit y avoir 1 'a' dans 'a'");
        assertEquals(2, StringUtils.nbOccurrence("aa", 'a'), "Il doit y avoir 2 'a' dans 'aa'");
        assertEquals(3, StringUtils.nbOccurrence("aaa", 'a'), "Il doit y avoir 3 'a' dans 'aaa'");

        assertEquals(1, StringUtils.nbOccurrence("Laval", 'L'), "Il doit y avoir 1 'L' dans 'Laval'");
    }
}
