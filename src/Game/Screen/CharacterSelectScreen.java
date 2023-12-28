package Game.Screen;

import Engine.UI.Screen;
import Game.UI.CharSelectBox;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CharacterSelectScreen extends Screen {
    @Override
    public void render(Graphics2D g2d) {
    }

    @Override
    public void init() {
        this.getParentWindow().setSize(800, 600);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.black);

        JLabel charSelectTitle = new JLabel("Select your character");
        charSelectTitle.setForeground(Color.yellow);
        charSelectTitle.setHorizontalAlignment(SwingConstants.CENTER);
        Path fontPath = Paths.get("resources/Font/pixeloid_mono.ttf");
        Font customFont;

        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, Files.newInputStream(fontPath)).deriveFont(25f);
        } catch (IOException | FontFormatException e) {
            customFont = Font.getFont(Font.MONOSPACED);
        }

        charSelectTitle.setFont(customFont);

        JPanel characterList = new JPanel();
        characterList.setLayout(new GridLayout(1, 3));
        characterList.setBackground(Color.black);

        CharSelectBox elfBox = new CharSelectBox("Elf");
        CharSelectBox markZuckBox = new CharSelectBox("Lizard");
        CharSelectBox harryBox = new CharSelectBox("Wizard");
        characterList.add(elfBox);
        characterList.add(markZuckBox);
        characterList.add(harryBox);

        elfBox.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new GameScreen("elf")));

        markZuckBox.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new GameScreen("lizard")));

        harryBox.addActionListener(e -> this.getParentWindow().replaceCurrentScreenWith(new GameScreen("wizard")));

        this.add(charSelectTitle);
        this.add(characterList);
    }
}
