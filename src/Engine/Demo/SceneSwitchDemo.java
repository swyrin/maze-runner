package Engine.Demo;

import Engine.UI.Screen;
import Engine.UI.Window;

import java.awt.*;

public class SceneSwitchDemo {
    public static void main(String... args) throws InterruptedException {
        Window window = new Window(new Dimension(1366, 768));

        Screen screen1 = new Screen(), screen2 = new Screen(), screen3 = new Screen();

        screen1.setBackground(Color.red);
        screen2.setBackground(Color.blue);
        screen3.setBackground(Color.green);

        screen1.add(new TextArea("Red"));
        screen2.add(new TextArea("Blue"));
        screen3.add(new TextArea("Green"));

        Screen[] screens = {screen1, screen2, screen3};
        window.setVisible(true);

        for (int i = 0; ; ++i) {
            System.out.println("Screen " + i + " - Using screen" + i % 3);
            window.replaceCurrentScreenWith(screens[i % 3]);
            Thread.sleep(1000);
        }
    }
}
