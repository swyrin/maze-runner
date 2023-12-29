package Game.Screen;

import Engine.UI.Screen;
import Game.UI.StyleButton;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        this.getParentWindow().setSize(600, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        JPanel buttonsContainer = new JPanel();

        buttonsContainer.setOpaque(false);
        buttonsContainer.setBackground(Color.black);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));

        StyleButton startButton = new StyleButton("Start Game");
        StyleButton ruleButton = new StyleButton("Rule");
        StyleButton exitButton = new StyleButton("Exit Game");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ruleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new CharacterSelectScreen()));

        ruleButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new RuleScreen()));

        exitButton.addActionListener(e -> this.getParentWindow().exit());

        buttonsContainer.add(startButton, BorderLayout.SOUTH);
        buttonsContainer.add(ruleButton, BorderLayout.SOUTH);
        buttonsContainer.add(exitButton, BorderLayout.SOUTH);

        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
