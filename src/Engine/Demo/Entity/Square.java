package Engine.Demo.Entity;

import Engine.Object.BaseEntity;

import java.awt.*;

public class Square extends BaseEntity {
    private Color color;

    /**
     * Create a square with random color.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Square(int x, int y) {
        super(x, y);
        this.color = new Color(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)
        );
    }

    @Override
    public void update() {

    }

    /**
     * Change to a new color.
     *
     * @param newColor New color to set.
     */
    public void changeColor(Color newColor) {
        this.color = newColor;
    }

    public Color getColor() {
        return this.color;
    }
}
