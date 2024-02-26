/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: A custom coordinates pair, created since Java is bad about extension method.
*/

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
