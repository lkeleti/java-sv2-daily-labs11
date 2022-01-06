package day03;

import org.junit.jupiter.api.Test;

import static day03.Validator.isEmpty;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void testIsBlank() {
        assertTrue(isEmpty(null));
        assertTrue(isEmpty(""));
        assertTrue(isEmpty("    "));
        assertFalse(isEmpty("a"));
        assertFalse(isEmpty("     a       "));
    }
}