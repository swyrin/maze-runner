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

        setSpeed(2);
    }
}
