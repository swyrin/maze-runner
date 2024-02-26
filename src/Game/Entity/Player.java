/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Represents Player object - it's you.
*/
package Game.Entity;

import Engine.Helper.StringHelper;
import Engine.Object.BaseEntity;
import Engine.RenderSetting;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Player extends BaseEntity implements KeyListener {
    private final String playerType;
    private int animCounter;
    private String animType;

    /**
     * Create an entity.
     *
     * @param x The initial x-axis position.
     * @param y The initial y-axis position.
     */
    public Player(int x, int y, String type) {
        super(x, y);

        this.playerType = type;
        this.animCounter = -1;
        this.animType = "idle";
    }

    public Image getAnimImg() {
        try {
            this.animCounter = (++this.animCounter) % (RenderSetting.maxFps); // just for safety
            int whatFrameToUse = this.animCounter / (RenderSetting.maxFps / 4); // we have like 4 frames/animation

            String playerImgAnimPath = "{player}_m_{type}_anim_f{frame}.png";
            return ImageIO.read(
                    Files.newInputStream(
                            Paths.get("resources/Player/" + StringHelper.toTitleCase(this.playerType) + "/" +
                                    playerImgAnimPath
                                            .replace("{player}", this.playerType)
                                            .replace("{type}", this.animType)
                                            .replace("{frame}", Integer.toString(whatFrameToUse))
                            )
                    )
            );
        } catch (IOException e) {
            //
        }

        return null;
    }

    public void resetAnimCounter() {
        this.animCounter = -1;
    }

    public void setAnimType(String animType) {
        this.animType = animType;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // same logic
        this.keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.resetAnimCounter();
        this.setAnimType("run");

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (this.getPendingY() == 0) this.addY(-1);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (this.getPendingX() == 0) this.addX(-1);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (this.getPendingY() == 0) this.addY(1);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (this.getPendingX() == 0) this.addX(1);

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.resetAnimCounter();
        this.setAnimType("idle");
        this.revokePending();
    }
}
