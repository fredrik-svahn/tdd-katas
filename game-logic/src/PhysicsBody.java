public class PhysicsBody {
    public Bounds bounds;
    public Position position;
    public Rotation rotation;

    public PhysicsBody(Bounds bounds) {
        this.bounds = bounds;
    }

    public boolean collidesWith(PhysicsBody other) {
        return false;
    }
}
