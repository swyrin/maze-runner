/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: A custom character selection button (of course it holds character data) - built on top of StyleButton
*/

package Game.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharSelectButton extends StyleButton {
    private Image charImg;

    public CharSelectButton(String name) {
        super(name);

        try {
            String imgPath = "resources/Player/" + name + "/" + name.toLowerCase() + "_m_idle_anim_f0.png";

            this.charImg = ImageIO.read(Files.newInputStream(Paths.get(imgPath)));
        } catch (IOException e) {
            //
        }

        this.setIcon(new ImageIcon(charImg));
    }
}
