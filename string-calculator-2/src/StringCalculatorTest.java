import org.junit.Before;
import org.junit.Test;

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
}