package Engine.Demo.Screen;


import Engine.UI.Screen;
import java.awt.*;

public class RedScreen extends Screen {
    @Override
    public void render(Graphics g) {
        setBackground(Color.red);
    }

    @Override
    public void init() {
        System.out.println("Red scene created.");
    }
};
