/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: The first screen you will see first when booting up the game.
*/

package Game.Screen;

import Engine.Loader.FontLoader;
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

        Font font = FontLoader.createFont("pixeloid_mono", 35);

        JLabel bigText = new JLabel("The Maze Runner");
        bigText.setFont(font);
        bigText.setHorizontalAlignment(JLabel.CENTER);
        bigText.setForeground(Color.white);
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

        this.add(bigText);
        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
