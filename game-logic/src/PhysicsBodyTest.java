import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicsBodyTest {
    @Test
    public void physicsBodiesAreColliding() {
        Bounds bounds1 = new Bounds(50, 50);
        Bounds bounds2 = new Bounds(50, 50);



        PhysicsBody body1 = new PhysicsBody(bounds1);
        PhysicsBody body2 = new PhysicsBody(bounds2);

        boolean colliding = body1.collidesWith(body2);
        assertEquals(true, colliding);
    }

}