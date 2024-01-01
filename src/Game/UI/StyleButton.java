/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: A customized JButton
*/

package Game.UI;

import Engine.Loader.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        this.setText(">" + this.getText() + "<");
        this.setForeground(Color.orange);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setText(this.getText().replace(">", "").replace("<", ""));
        this.setForeground(Color.yellow);
    }
}