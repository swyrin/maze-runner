package Engine;

import Engine.UI.Screen;
import Engine.UI.Window;

public class GameController {
    public void init() {
        if (RenderSetting.useHardwareAcceleration) {
            System.setProperty("sun.java2d.opengl", "True");
            System.setProperty("sun.java2d.opengl.fbobject", "False");
            System.setProperty("sun.java2d.xrender", "True");
            System.setProperty("sun.java2d.nodraw", "True");
        }
    }

    public void start(Window gameWindow, Screen startingScreen) {
        gameWindow.replaceCurrentScreenWith(startingScreen);
        gameWindow.setVisible(true);
    }
}
