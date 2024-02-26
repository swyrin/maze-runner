/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Font loader class, only used for read the .ttf files & register to JVM.
*/

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
