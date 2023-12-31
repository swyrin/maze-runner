package Game.Utility;

public class CoordinatePair {
    private final int x;
    private final int y;

    public CoordinatePair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoordinatePair otherPair)) return false;

        return this.x == otherPair.getX() && this.y == otherPair.getY();
    }
}
