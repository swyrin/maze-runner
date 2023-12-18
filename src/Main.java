import Engine.GameController;
import Game.Screen.MainScreen;
import Game.TheGame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.init();

        TheGame game = new TheGame(new Dimension(600, 600));
        MainScreen mainScreen = new MainScreen();

        controller.start(game, mainScreen);
    }
}