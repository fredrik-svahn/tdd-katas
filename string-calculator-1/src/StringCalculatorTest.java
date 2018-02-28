import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator sc;
    @Before
    public void setup()  {
        sc = new StringCalculator();
    }

    @Test
    public void emptyStringReturnsZero() {
        assertEquals(0, sc.calculate(""));
    }

    @Test
    public void stringWithOneNumberReturnsTheNumber() {
        for(int i = 0; i < 100; i++ ) {
            assertEquals(i, sc.calculate(Integer.toString(i)));
        }
    }

    @Test
    public void stringWithTwoNumbersShouldReturnTheSumOfTheNumbers() {
        assertEquals(0, sc.calculate("0,0"));
        assertEquals(1, sc.calculate("1,0"));
        assertEquals(2, sc.calculate("1,1"));
        assertEquals(7, sc.calculate("3,4"));
        assertEquals(13, sc.calculate("6,7"));
        assertEquals(25, sc.calculate("13,12"));
    }

    @Test
    public void stringWithUnknownAmountOfNumbersShouldReturnTheSumOfTheNumbers() {
        assertEquals(0, sc.calculate("0,0"));
        assertEquals(1, sc.calculate("1,0"));
        assertEquals(10, sc.calculate("2,5,1,2"));
        assertEquals(128, sc.calculate("3,4,55,12,35,10,9"));
        assertEquals(35, sc.calculate("8,2,3,12,10"));
    }

    @Test
    public void stringSeparatedWithNewlinesShouldStillReturnSum() {
        assertEquals(0, sc.calculate("0\n0"));
        assertEquals(6, sc.calculate("1\n2\n3"));
        assertEquals(10, sc.calculate("2\n2\n2\n2\n2"));
    }

    @Test
    public void stringSeparatedWithBothCommasAndNewlinesShouldReturnSum() {
        assertEquals(0, sc.calculate("0,0\n0,0\n0"));
        assertEquals(20,sc.calculate("10,2\n2\n2,4"));
    }

    @Test
    public void stringThatContainsDeclarationOfCustomDelimiterShouldReturnSum() {
        assertEquals(28, sc.calculate("//[-]\n1-2-3-4-5-6-7"));
        assertEquals(34, sc.calculate("//[.]\n5.7.2.3.4.6.7"));
    }
}