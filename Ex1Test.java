import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @Test
    void number2Int() {
        assertEquals("101b2", Ex1.int2Number(5, 2)); // Base 2 representation of 5

    }

    @Test
    void isNumber() {
        assertTrue(Ex1.isNumber("101b2"));         // Valid base 2 number

    }

    @Test
    void int2Number() {
        assertEquals("0b2", Ex1.int2Number(0, 2));  // Base 2 representation of 0

    }

    @Test
    void testEquals() {
        assertFalse(Ex1.equals("101b2", "5b20")); // Invalid base for second number

    }

    @Test
    void maxIndex() {
        String[] arr1 = {"101b2", "F1b16", "77b10"};
        assertEquals(1, Ex1.maxIndex(arr1)); // "F1b16" (241 in d
    }


}