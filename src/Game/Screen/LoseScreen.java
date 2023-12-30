package Game.Screen;

import Engine.Loader.FontLoader;
import Engine.UI.Screen;
import Game.UI.StyleButton;

import javax.swing.*;
import java.awt.*;

public class LoseScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        this.getParentWindow().setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        Font font = FontLoader.createFont("pixeloid_mono", 60);

        JLabel bigText = new JLabel("You lose");
        bigText.setFont(font);
        bigText.setHorizontalAlignment(JLabel.CENTER);
        bigText.setForeground(Color.yellow);

        JLabel favorText = new JLabel("Try harder next time!");
        favorText.setHorizontalAlignment(JLabel.CENTER);
        favorText.setForeground(Color.orange);
        favorText.setFont(font.deriveFont(16f));

        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setOpaque(false);
        buttonsContainer.setBackground(Color.black);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));

        StyleButton startButton = new StyleButton("Start Again");
        StyleButton returnButton = new StyleButton("Main Screen");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new CharacterSelectScreen()));

        returnButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new MainScreen()));

        buttonsContainer.add(startButton, BorderLayout.SOUTH);
        buttonsContainer.add(returnButton, BorderLayout.SOUTH);

        this.add(bigText, BorderLayout.NORTH);
        this.add(favorText);
        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
