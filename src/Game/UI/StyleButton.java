package Game.UI;

import Engine.Loader.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StyleButton extends JButton implements MouseListener {
    public StyleButton(String str) {
        super(str);

        Font customFont = FontLoader.createFont("pixeloid_mono", 30f);
        this.setFont(customFont);

        this.setForeground(Color.yellow);
        this.setBackground(Color.black);
        this.setOpaque(false);
        this.setBorder(null);
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