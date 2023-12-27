import Engine.GameController;
import Game.Screen.MainScreen;
import Game.TheGame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();

        controller
                .setupOpenGLHardwareAcceleration()
                .setInitialWindow(new TheGame(new Dimension(1200, 800)))
                .setInitialScreen(new MainScreen())
                .start();
    }
}