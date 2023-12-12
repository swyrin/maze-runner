package Engine.Demo.Screen;

import Engine.Demo.Entity.Square;
import Engine.UI.Screen;

import java.awt.*;
import java.util.Random;

public class StressTestScreen extends Screen {
    private Square[] squares;

    public StressTestScreen(Square[] squares) {
        super();
        this.squares = squares;
    }
    @Override
    public void render(Graphics2D g2d) {
        int n = squares.length;

        for (int i = 0; i < n; ++i) {
            Square sq = squares[i];

            // System.out.printf("Updating square %d\n", i);

            int xD = new Random().nextInt(-10, 11);
            int yD = new Random().nextInt(-10, 11);

            sq.addX(xD);
            sq.addY(yD);

            if ((0 <= sq.getX() && sq.getX() <= this.getParentWindow().getWidth()) && (0 <= sq.getY() && sq.getY() <= this.getParentWindow().getHeight()))
                sq.move();
            else {
                sq.addX(-xD);
                sq.addY(-yD);
            }

            g2d.setColor(sq.getColor());
            g2d.fillRect(sq.getX(), sq.getY(), 30, 30);
        }

        this.getParentWindow().setTitle(String.valueOf(this.fpsCounter.getFps()));
    }

    @Override
    public void init() {

    }
}
