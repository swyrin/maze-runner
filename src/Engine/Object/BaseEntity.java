package Engine.Object;

import java.awt.*;

/**
 * Represents an entity on the screen.
 */
public abstract class BaseEntity {
    private int x, y;

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public BaseEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move the entity.
     *
     * @param xDisplacement The x-axis displacement.
     * @param yDisplacement The y-axis displacement.
     * @return The distance travelled.
     */
    public double move(int xDisplacement, int yDisplacement) {
        this.x += xDisplacement;
        this.y += yDisplacement;

        return Math.sqrt(xDisplacement * xDisplacement + yDisplacement * yDisplacement);
    }

    /**
     * Move the entity after applying a set of displacement(s)
     */
    public double move() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    /**
     * Check if 2 entities are position-absolute colliding with each other.
     *
     * @param other The other entity to check.
     * @return The boolean, true if they are position-absolute colliding, false otherwise.
     */
    public boolean isCollideWith(BaseEntity other) {
        return getX() == other.getX() && getY() == other.getY();
    }

    /**
     * Check if 2 entities are side colliding with each other.
     *
     * @param other The other entity to check.
     * @return The boolean, true if they are side colliding, false otherwise.
     */
    public boolean isSideCollideWith(BaseEntity other) {
        return Math.abs(getX() - other.getX()) == 1 || Math.abs(getY() - other.getY()) == 1;
    }

    /**
     * Get current x-axis position.
     *
     * @return The x-axis position.
     */
    public int getX() {
        return x;
    }

    /**
     * Get current y-axis position.
     *
     * @return The y-axis position.
     */
    public int getY() {
        return y;
    }
}
