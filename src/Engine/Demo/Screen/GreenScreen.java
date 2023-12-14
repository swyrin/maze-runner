package Engine.Demo.Screen;

import Engine.UI.Screen;

import java.awt.*;

public class GreenScreen extends Screen {
    public void render(Graphics2D g) {
        setBackground(Color.green);
    }

    @Override
    public void init() {
        System.out.println("Green scene created.");
    }
}
