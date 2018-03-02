import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator sc;
    @Before
    public void setup() {
        sc = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroOnEmptyString() {
        assertEquals(0, sc.add(""));
    }

    @Test
    public void shouldReturnNumberOnStringWithOnlyNumber() {
        assertEquals(0, sc.add("0"));
        assertEquals(5, sc.add("5"));
        assertEquals(100, sc.add("100"));
    }

    @Test
    public void shouldReturnSumWhenStringIsTwoCommaSeparatedNumbers() {
        assertEquals(10, sc.add("5, 5"));
        assertEquals(25, sc.add("12, 13"));
        assertEquals(17, sc.add("9, 8"));
    }

    @Test
    public void shouldReturnSumOnStringWithCommaSeparatedValues() {
        assertEquals(0, sc.add("0, 0, 0"));
        assertEquals(150, sc.add("75, 25, 25, 25"));
        assertEquals(597, sc.add("25, 50, 150, 250, 122"));
    }

    @Test
    public void shouldReturnSumWhenSeparatedWithNewlinesInstead() {
        assertEquals(0, sc.add("0\n0\n0"));
        assertEquals(150, sc.add("75\n25\n25\n25"));
        assertEquals(597, sc.add("25\n50\n150\n250\n122"));
    }

    @Test
    public void shouldReturnSumWhenSeparatedWithCommasWithoutSpaces() {
        assertEquals(0, sc.add("0,0,0,0,0"));
        assertEquals(50, sc.add("25,15,10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnIllegalSeparator() {
        sc.add("0,\n 5");
        sc.add("67\n,,,25");
    }

    @Test
    public void shouldAllowAddingExtraDelimiters() {
        assertEquals(7+3+5, sc.add("//[;]\n7;3;5"));
        assertEquals(60+30+20+5+7+8, sc.add("//[.]\n60, 30,20\n5\n7.8"));
    }
}