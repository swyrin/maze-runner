package Engine.Object;

/**
 * Represents an entity on the screen.
 */
public abstract class BaseEntity {
    private int x, y;
    private int pendingX, pendingY;

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public BaseEntity(int x, int y) {
        this.x = x;
        this.y = y;
        this.pendingX = 0;
        this.pendingY = 0;
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
     * Move the entity after applying a set of pending displacement(s)
     */
    public double move() {
        int saveX = this.pendingX;
        int saveY = this.pendingY;
        this.revokePending();
        return this.move(saveX, saveY);
    }

    /**
     * Add x to pending x-axis movement.
     *
     * @param x x-axis distance.
     */
    public void addX(int x) {
        this.pendingX += x;
    }

    /**
     * Add y to pending y-axis movement.
     *
     * @param y y-axis distance.
     */
    public void addY(int y) {
        this.pendingY += y;
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
     * Revoke pending y-axis movement.
     */
    public void revokePendingX() {
        this.pendingX = 0;
    }

    /**
     * Revoke pending x-axis movement.
     */
    public void revokePendingY() {
        this.pendingY = 0;
    }

    /**
     * Revoke all pending movements.
     */
    public void revokePending() {
        this.revokePendingX();
        this.revokePendingY();
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

    /**
     * Get pending x-axis distance
     *
     * @return Pending x-axis distance
     */
    public int getPendingX() {
        return pendingX;
    }

    /**
     * Get pending y-axis distance
     *
     * @return Pending y-axis distance
     */
    public int getPendingY() {
        return pendingY;
    }

    /**
     * Get current post-pending-addition x-axis position.
     *
     * @return The post-pending-addition x-axis position.
     */
    public int getPostPendingX() {
        return x + pendingX;
    }

    /**
     * Get current post-pending-addition y-axis position.
     *
     * @return The post-pending-addition y-axis position.
     */
    public int getPostPendingY() {
        return y + pendingY;
    }
}
