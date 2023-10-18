package Engine.UI;

import javax.swing.*;
import java.awt.*;

/**
 * The window to be shown.
 */
public class Window extends JFrame {
    /**
     * Dimension of the window.
     */
    private final Dimension dimension;

    /**
     * The current shown window.
     */
    private Screen currentCanonicalScreen;

    /**
     * Fullscreen status.
     */
    private boolean isFullscreen;

    /**
     * Create a fixed window, with a fixed dimension, at center of the screen.
     *
     * @param dimension The dimension of the window.
     */
    public Window(Dimension dimension) {
        this.dimension = dimension;
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.isFullscreen = false;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * Replace the screen with another screen.
     *
     * @param anotherScreen The screen to replace with.
     */
    public void replaceCurrentScreenWith(Screen anotherScreen) {
        this.getContentPane().invalidate();
        this.getContentPane().removeAll();

        this.getContentPane().add(anotherScreen);
        this.getContentPane().revalidate();
        anotherScreen.setVisible(true);
        anotherScreen.requestFocus();
        this.repaint();

        this.setCurrentCanonicalScreen(anotherScreen);
        anotherScreen.setParentWindow(this);
    }

    /**
     * Get current window's dimensions.
     *
     * @return The dimensions.
     */
    public Dimension getDimension() {
        return dimension;
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
}
