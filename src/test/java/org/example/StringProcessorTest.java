package org.example;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
public class StringProcessorTest extends TestCase {
    @Test
    public void testIsStrongPassword() {
        StringProcessor string = new StringProcessor();
        assertFalse(string.isStrongPassword("adilet"));
        assertTrue(string.isStrongPassword("Ad1@"));
    }
    @Test
    public void testCalculateDigits() {
        StringProcessor string = new StringProcessor();
        assertEquals(2, string.calculateDigits("12"));
        assertEquals(5, string.calculateDigits("12345"));
        assertEquals(0, string.calculateDigits("hello"));
        assertEquals(3, string.calculateDigits("890"));
        assertEquals(4, string.calculateDigits("2004"));
    }
    @Test
    public void testCalculateWords() {
        StringProcessor string = new StringProcessor();
        assertEquals(0, string.calculateWords("19"));
        assertEquals(1, string.calculateWords("hello "));
        assertEquals(1, string.calculateWords("hello    "));
        assertEquals(1, string.calculateWords("    hello"));
        assertEquals(4, string.calculateWords("It is test cases"));
    }
    @Test
    public void testCalculateExpression() {
        StringProcessor string = new StringProcessor();
        assertEquals(5.0, string.calculateExpression("1 + 4"));
        assertEquals(0.0, string.calculateExpression("5 - (2+ 3)"));
        assertEquals(100.0, string.calculateExpression("20 * (4 + 1)"));
        assertEquals(-1.0, string.calculateExpression("5 - 6"));
        assertEquals(4.0, string.calculateExpression("64 / 16"));
    }
}
