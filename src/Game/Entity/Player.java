package Game.Entity;

import Engine.Helper.StringHelper;
import Engine.Object.BaseEntity;

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
    private int speed;

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
        this.speed = 1;
    }

    public Image getAnimImg() {
        try {
            ++this.animCounter;
            this.animCounter = this.animCounter % 4; // just for safety

            String playerImgAnimPath = "{player}_m_{type}_anim_f{frame}.png";
            return ImageIO.read(
                    Files.newInputStream(
                            Paths.get("resources/Player/" + StringHelper.toTitleCase(this.playerType) + "/" +
                                    playerImgAnimPath
                                            .replace("{player}", this.playerType)
                                            .replace("{type}", this.animType)
                                            .replace("{frame}", Integer.toString(this.animCounter))
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

    public void setSpeed(int speed) {
        this.speed = speed;
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
                if (this.getPendingY() == 0) this.addY(-this.speed);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (this.getPendingX() == 0) this.addX(-this.speed);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (this.getPendingY() == 0) this.addY(this.speed);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (this.getPendingX() == 0) this.addX(this.speed);
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
