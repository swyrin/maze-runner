/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!
/// DO NOT TOUCH THIS CODE UNLESS YOU GET A "YES" DIRECTLY FROM MY MOUTH!!!!!!!!!!

package Engine.Demo;

import Engine.Demo.Entity.Square;
import Engine.Demo.Screen.StressTestScreen;
import Engine.GameController;
import Engine.UI.Window;

import java.awt.*;
import java.util.Random;

public class StressTestingDemo {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.init();

        Window w = new Window(new Dimension(1900, 1000));

        Color[] colors = {Color.CYAN, Color.WHITE, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};
        Square[] squares = new Square[4500];

        StressTestScreen screen = new StressTestScreen(squares);
        screen.setBackground(Color.black);

        int n = squares.length;

        for (int i = 0; i < n; ++i) {
            squares[i] = new Square(
                    new Random().nextInt(0, w.getWidth()),
                    new Random().nextInt(0, w.getHeight()),
                    colors[new Random().nextInt(0, 6)]
            );
        }

        controller.start(w, screen);
    }
}
