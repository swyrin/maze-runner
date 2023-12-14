package Engine.Demo.Entity;

import Engine.Object.BaseEntity;

import java.awt.*;

public class Square extends BaseEntity {
    private Color color;

    /**
     * Create a square.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Square(int x, int y) {
        this(x, y, Color.cyan);
    }

    /**
     * Create a square with position and color.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     * @param color The initial color.
     */
    public Square(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * Change to a new color.
     *
     * @param newColor New color to set.
     */
    public void colorChange(Color newColor) {
        this.color = newColor;
    }

    public Color getColor() {
        return this.color;
    }
}
