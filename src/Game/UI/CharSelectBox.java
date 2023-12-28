package Game.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharSelectBox extends StyleButton {
    private Image charImg;

    public CharSelectBox(String name) {
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
