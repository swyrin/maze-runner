package Game.Screen;

import Engine.UI.Screen;
import Game.UI.CharSelectBox;
import Game.UI.StyleButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
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

        JTextArea tooltip = new JTextArea("Test");
        tooltip.setEditable(false);
        tooltip.setSize(700, 60);

        JPanel characterList = new JPanel();
        characterList.setLayout(new GridLayout(1,3));
        characterList.setBackground(Color.black);
        characterList.add(new CharSelectBox("Elf", "resources/Player/Elf/elf_m_idle_anim_f0.png", "TODO 1"));
        characterList.add(new CharSelectBox("Lizard", "resources/Player/Lizard/lizard_m_idle_anim_f0.png", "TODO 2"));
        characterList.add(new CharSelectBox("Wizard", "resources/Player/Elf/elf_m_idle_anim_f0.png", "TODO 3"));

        this.add(charSelectTitle);
        this.add(characterList);
        // this.add(tooltip);
    }
}
