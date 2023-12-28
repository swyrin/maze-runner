package Game.UI;

import Engine.Helper.StringHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharSelectBox extends JButton implements MouseListener {
    private String name;
    private Image charImg;
    private String tooltip;

    public CharSelectBox(String name, String imagePath, String tooltip) {
        try {
            this.name = name;
            this.charImg =  ImageIO.read(Files.newInputStream(Paths.get(imagePath)));
            this.tooltip = tooltip;
        } catch (IOException e) {
            //
        }

        try {
            Font customFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    Files.newInputStream(Paths.get("resources/Font/pixeloid_mono.ttf"))
            ).deriveFont(30f);

            this.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            //
        }


        this.setText(tooltip);
        this.setBackground(Color.black);
        this.setForeground(Color.yellow);

        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());

        this.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setForeground(Color.orange);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setForeground(Color.yellow);
    }
}
