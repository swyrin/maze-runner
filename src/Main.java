/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Main class to boot up the game.
*/

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