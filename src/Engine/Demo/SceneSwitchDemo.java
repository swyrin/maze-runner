package Engine.Demo;

import Engine.Demo.Screen.BlueScreen;
import Engine.Demo.Screen.GreenScreen;
import Engine.Demo.Screen.RedScreen;
import Engine.UI.Screen;
import Engine.UI.Window;

import java.awt.*;

public class SceneSwitchDemo {
    public static void main(String... args) throws InterruptedException {
        Window window = new Window(new Dimension(1366, 768));

        Screen screen1 = new RedScreen(),
                screen2 = new BlueScreen(),
                screen3 = new GreenScreen();

        Screen[] screens = {screen1, screen2, screen3};
        window.setVisible(true);

        for (int i = 0; ; ++i) {
            System.out.println("Screen " + i + " - Using screen" + i % 3);
            window.replaceCurrentScreenWith(screens[i % 3]);
            Thread.sleep(1000);
        }
    }
}
