package Game.Screen;

import Engine.UI.Screen;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setOpaque(false);
        buttonsContainer.setBackground(Color.black);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));

        JButton startButton = new JButton("Start Game");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> {
            this.getParentWindow().replaceCurrentScreenWith(new GameScreen());
        });

        buttonsContainer.add(startButton, BorderLayout.SOUTH);

        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
