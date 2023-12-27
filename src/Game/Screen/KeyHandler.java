package Game.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //go up
        if(code == KeyEvent.VK_W) upPressed = true;

        //go down
        if(code == KeyEvent.VK_S) downPressed = true;

        //go left
        if(code == KeyEvent.VK_A) leftPressed = true;

        //go right
        if(code == KeyEvent.VK_D) rightPressed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        //go up
        if(code == KeyEvent.VK_W) upPressed = false;

        //go down
        if(code == KeyEvent.VK_S) downPressed = false;

        //go left
        if(code == KeyEvent.VK_A) leftPressed = false;

        //go right
        if(code == KeyEvent.VK_D) rightPressed = false;

    }
}