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
     * Bind the starting screen. Use in conjunction with setInitialGameWindow().
     *
     * @param s The screen to bind.
     * @return The controller.
     */
    public GameController setInitialScreen(Screen s) {
        this.startingScreen = s;

        return this;
    }

    public GameController setupOpenGLHardwareAcceleration() {
        if (RenderSetting.useHardwareAcceleration) {
            System.setProperty("sun.java2d.opengl", "True");
            System.setProperty("sun.java2d.opengl.fbobject", "False");
            System.setProperty("sun.java2d.xrender", "True");
            System.setProperty("sun.java2d.nodraw", "True");
        }

        return this;
    }

    public void start() {
        this.startingWindow.replaceCurrentScreenWith(this.startingScreen);
        this.startingWindow.setVisible(true);
    }
}
