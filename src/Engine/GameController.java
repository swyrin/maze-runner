/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Define a game instance.
*/

package Engine;

import Engine.UI.Screen;
import Engine.UI.Window;

public class GameController {
    private Window startingWindow;
    private Screen startingScreen;

    /**
     * Bind the starting window.
     *
     * @param w The window to bind.
     * @return The controller.
     */
    public GameController setInitialWindow(Window w) {
        this.startingWindow = w;

        return this;
    }

    /**
     * Bind the starting screen. Use in conjunction with {@link #setInitialWindow(Window)}.
     *
     * @param s The screen to bind.
     * @return The controller.
     */
    public GameController setInitialScreen(Screen s) {
        this.startingScreen = s;

        return this;
    }

    /**
     * Enable HW acceleration for better performance.
     *
     * @return The controller.
     */
    public GameController setupOpenGLHardwareAcceleration() {
        System.setProperty("sun.java2d.opengl", "True");
        System.setProperty("sun.java2d.opengl.fbobject", "True");
        System.setProperty("sun.java2d.xrender", "True");
        System.setProperty("sun.java2d.nodraw", "True");

        return this;
    }

    /**
     * Start the game.
     */
    public void start() {
        this.startingWindow.replaceCurrentScreenWith(this.startingScreen);
        this.startingWindow.setVisible(true);
    }
}
