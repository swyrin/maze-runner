package Engine.Demo.Entity;

import Engine.Object.BaseEntity;

import java.awt.*;

public class Square extends BaseEntity {
    private Color color;

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Square(int x, int y) {
        super(x, y);
        this.color = new Color( (int)(Math.random()*256),
                                (int)(Math.random()*256),
                                (int)(Math.random()*256));
    }

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     * @param e The initial square's color.
     */
    public Square(int x, int y, Color e) {
        super(x, y);
        this.color = e;
    }

    /**
     * Change into to Color.a
     *
     * @param a
     */
    public void colorChange(Color a) {
        this.color = a;
    }

    public Color getColor() {
        return this.color;
    }
}
