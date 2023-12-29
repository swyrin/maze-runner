package Game.Screen;

import Engine.UI.Screen;
import Game.UI.StyleButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RuleScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        this.getParentWindow().setSize(1150, 600);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        JLabel ruleTitle = new JLabel("RULE");
        ruleTitle.setForeground(Color.yellow);
        ruleTitle.setHorizontalAlignment(SwingConstants.CENTER);
        Path fontPath = Paths.get("resources/Font/pixeloid_mono.ttf");
        Font customFont;

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, Files.newInputStream(fontPath)).deriveFont(57f);
        } catch (IOException | FontFormatException e) {
            customFont = Font.getFont(Font.MONOSPACED);
        }

        ruleTitle.setFont(customFont);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.yellow);
        textArea.setFont(customFont.deriveFont(25f));
        textArea.append(
                """
                          The rule is very simple:
                          1. There are keys on the map.
                          2. You have to collect the key (by using W/A/S/D keys to move).
                            - Up/Left/Down/Right direction, respectively.
                          3. Once you collected all the keys, step on the pink platform
                             to move to next subzone.
                          4. If all subzones completed, you are done!
                          5. In case you see this is easy, there are enemies wandering
                             around the map.
                          
                          The scoring:
                          - The score will be your total time clearing all the subzones.
                          - Think like a speedrunning game.
                        """);

        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setOpaque(false);
        buttonsContainer.setBackground(Color.black);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));

        StyleButton startButton = new StyleButton("Start Game");
        StyleButton backButton = new StyleButton("Back");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new CharacterSelectScreen()));
        backButton.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new MainScreen()));

        buttonsContainer.add(startButton, BorderLayout.SOUTH);
        buttonsContainer.add(backButton, BorderLayout.SOUTH);

        this.add(ruleTitle, BorderLayout.NORTH);
        this.add(textArea);
        this.add(buttonsContainer, BorderLayout.SOUTH);
    }
}
