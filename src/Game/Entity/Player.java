package Game.Entity;

import Engine.Helper.StringHelper;
import Engine.Object.BaseEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Player extends BaseEntity {
    private String playerType;
    private final String playerImgAnimPath =  "{player}_m_{type}_anim_f{frame}.png";

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Player(int x, int y, String type) {
        super(x, y);

        this.playerType = type;
    }

    public Image getAnimImg(String animType, int frame) {
        try {
            frame = frame % 4; // just for safety
            return ImageIO.read(
                    Files.newInputStream(
                            Paths.get("resources/Players/" + StringHelper.toTitleCase(this.playerType) + "/" +
                                    this.playerImgAnimPath
                                            .replace("{player}", this.playerType)
                                            .replace("{type}", animType)
                                            .replace("{frame}", Integer.toString(frame))
                            )
                    )
            );
        } catch (IOException e) {
            //
        }

        return null;
    }
}
