package Engine.Loader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {
    public static Font createFont(String name, float size) {
        try {
            return Font.createFont(
                    Font.TRUETYPE_FONT,
                    new File("resources/Font/" + name + ".ttf")
            ).deriveFont(size);
        } catch (IOException | FontFormatException e) {
            return Font.getFont(Font.MONOSPACED);
        }
    }
}
