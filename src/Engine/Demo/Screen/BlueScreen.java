package Engine.Demo.Screen;

import Engine.UI.Screen;

import java.awt.*;

public class BlueScreen extends Screen {
    public void render(Graphics2D g) {
        setBackground(Color.blue);
    }

    @Override
    public void init() {
        System.out.println("Blue scene created.");
    }
}
