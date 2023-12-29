package Engine.Loader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {
    public static Font createFont(String name, float size) {
        try {
            Font font = Font.createFont(
                    Font.TRUETYPE_FONT,
                    new File("resources/Font/" + name + ".ttf")
            ).deriveFont(size);

            // https://stackoverflow.com/questions/7265178/jlabel-html-text-ignores-setfont
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);

            return font;
        } catch (IOException | FontFormatException e) {
            return Font.getFont(Font.MONOSPACED);
        }
    }
}
