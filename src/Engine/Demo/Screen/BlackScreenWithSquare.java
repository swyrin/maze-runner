package Engine.Demo.Screen;

import Engine.Demo.Entity.Square;
import Engine.UI.Screen;

import java.awt.*;

public class BlackScreenWithSquare extends Screen {
    private final Square sq;

    public BlackScreenWithSquare(Square sq) {
        super();
        this.sq = sq;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(sq.getColor());
        g.fillRect(sq.getX(), sq.getY(), 30, 30);
    }

    @Override
    public void init() {
    }
}
