import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundsTest {
    @Before
    public void setup() {

    }

    @Test
    public void areaShouldBeCorrectlyCalculated() {
        Bounds bounds = new Bounds();

        for(int i = 0; i < 25; i++) {
            bounds.setWidth(i);
            for(int a = 0; a < 25; a++) {
                bounds.setHeight(a);
                assertEquals(a*i, bounds.getArea());
            }
        }
    }
}