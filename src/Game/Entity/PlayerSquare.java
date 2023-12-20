package Game.Entity;

import Engine.UI.Screen;

import java.awt.*;

public class PlayerSquare extends Screen {
    private final Player pl;

    public PlayerSquare(Player pl) {
        super();
        this.pl = pl;
    }

    @Override
    public void render(Graphics2D g) {
        // g.setColor(pl.getColor());
        g.fillRect(pl.getX(), pl.getY(), 30, 30);
    }

    @Override
    public void init() {
    }
}
