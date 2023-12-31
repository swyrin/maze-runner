package Engine.Object;

import Engine.UI.Screen;

/**
 * Represents an entity on the screen.
 */
public abstract class BaseEntity {
    private double x, y;
    private double pendingX, pendingY;
    private Screen screen;

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public BaseEntity(double x, double y) {
        this.x = x;
        this.y = y;
        this.pendingX = 0;
        this.pendingY = 0;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    /**
     * Move the entity by a displacement.
     *
     * @param xDisplacement The x-axis displacement.
     * @param yDisplacement The y-axis displacement.
     */
    public void move(double xDisplacement, double yDisplacement) {
        if (xDisplacement == 0 && yDisplacement == 0) return;

        this.x += xDisplacement;
        this.y += yDisplacement;
    }

    /**
     * Get distance multiplier per renderer frame.
     * This should return the "distance" multiplier between frame[i] and frame[i - 1]
     * @return The multiplier.
     */
    public double getDistanceFactor() {
        return this.screen.getDeltaTime().toMillis() / 1000f;
    }

    /**
     * Move to a set location.
     * @param x x-axis location.
     * @param y y-axis location.
     */
    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move the entity after applying a set of pending displacement(s)
     */
    public void move() {
        double saveX = this.pendingX;
        double saveY = this.pendingY;
        this.revokePending();
        this.move(saveX, saveY);
    }

    /**
     * Add x to pending x-axis movement.
     *
     * @param x x-axis distance.
     */
    public void addX(double x) {
        this.pendingX += x;
    }

    /**
     * Add y to pending y-axis movement.
     *
     * @param y y-axis distance.
     */
    public void addY(double y) {
        this.pendingY += y;
    }

    /**
     * Check if 2 entities are position-absolute colliding with each other.
     *
     * @param other The other entity to check.
     * @return The boolean, true if they are position-absolute colliding, false otherwise.
     */
    public boolean isCollideWith(BaseEntity other) {
        double threshold = 0.3;
        return Math.abs(getX() - other.getX()) <= threshold && Math.abs(getY() - other.getY()) <= threshold;
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
    public double getX() {
        return x;
    }

    /**
     * Get current y-axis position.
     *
     * @return The y-axis position.
     */
    public double getY() {
        return y;
    }

    /**
     * Get pending x-axis distance
     *
     * @return Pending x-axis distance
     */
    public double getPendingX() {
        return pendingX;
    }

    /**
     * Get pending y-axis distance
     *
     * @return Pending y-axis distance
     */
    public double getPendingY() {
        return pendingY;
    }

    /**
     * Get current post-pending-addition x-axis position.
     *
     * @return The post-pending-addition x-axis position.
     */
    public double getPostPendingX() {
        return x + pendingX;
    }

    /**
     * Get current post-pending-addition y-axis position.
     *
     * @return The post-pending-addition y-axis position.
     */
    public double getPostPendingY() {
        return y + pendingY;
    }
}
