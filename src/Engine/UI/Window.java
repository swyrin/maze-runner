/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: The outer border part of a Window
*/

package Engine.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * The window to be shown.
 */
public class Window extends JFrame {
    /**
     * The current shown window.
     */
    private Screen currentCanonicalScreen;

    private boolean centered;

    /**
     * Create a fixed window, with a fixed dimension, at center of the screen.
     *
     * @param dimension The dimension of the window.
     */
    public Window(Dimension dimension) {
        this.setSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.centered = false;
    }

    /**
     * Replace the screen with another screen.
     *
     * @param anotherScreen The screen to replace with.
     */
    public void replaceCurrentScreenWith(Screen anotherScreen) {
        Screen currentOngoingScreen = getCurrentCanonicalScreen();
        if (currentOngoingScreen != null) currentOngoingScreen.dispose();

        this.getContentPane().invalidate();
        this.getContentPane().removeAll();

        this.getContentPane().add(anotherScreen);
        this.getContentPane().revalidate();
        anotherScreen.setVisible(true);

        anotherScreen.requestFocus();

        this.setCurrentCanonicalScreen(anotherScreen);
        anotherScreen.setParentWindow(this);
        anotherScreen.init();
    }

    /**
     * Get current showing screen.
     *
     * @return The current screen.
     */
    public Screen getCurrentCanonicalScreen() {
        return currentCanonicalScreen;
    }

    /**
     * Set current showing screen.
     * Not intended to be called manually for outside classes.
     * Use {@link #replaceCurrentScreenWith(Screen)} as the intended way.
     *
     * @param currentCanonicalScreen The screen.
     */
    public void setCurrentCanonicalScreen(Screen currentCanonicalScreen) {
        this.currentCanonicalScreen = currentCanonicalScreen;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);

        if (this.centered) {
            // hacky code to move the window to center.
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((screenDim.getWidth() - this.getWidth()) / 2);
            int y = (int) ((screenDim.getHeight() - this.getHeight()) / 2);
            this.setLocation(x, y);
        }
    }

    /**
     * Whether this window should be centered.
     *
     * @param centered the value.
     */
    public void setCentered(boolean centered) {
        this.centered = centered;
    }
    /**
     * Exit the window.
     */
    public void exit() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
