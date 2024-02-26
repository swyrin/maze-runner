/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Represents Knight object - it's a villain by the way.
*/
package Game.Entity;

public class Knight extends Player {
    /**
     * Create a knight as enemy.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Knight(int x, int y) {
        super(x, y, "knight");
    }
}
