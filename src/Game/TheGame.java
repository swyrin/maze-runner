/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: The window of the game.
*/

package Game;

import Engine.UI.Window;

import javax.swing.*;
import java.awt.*;

public class TheGame extends Window {
    /**
     * Create a fixed window, with a fixed dimension, at center of the screen.
     *
     * @param dimension The dimension of the window.
     */
    public TheGame(Dimension dimension) {
        super(dimension);

        setTitle("Maze Runner");
        setIconImage(new ImageIcon("resources/game_icon.png").getImage());
        setCentered(true);
    }
}
