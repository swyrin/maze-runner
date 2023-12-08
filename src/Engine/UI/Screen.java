package Engine.UI;

import Engine.Core.KeyBinding;
import Engine.Helper.RenderHelper;

import javax.swing.*;
import java.awt.*;

/**
 * The screen to be shown on the window.
 * Please note this is just the basic screen, extension is ill-advised.
 */
public abstract class Screen extends JPanel {
    /**
     * The parent window handling this.
     */
    private Window parentWindow;

    /**
     * Desired frame(s) per second.
     */
    private final int targetFps;

    public Screen(int targetFps) {
        this.targetFps = targetFps;
        this.init();
    }

    public Screen() {
        this(60);
    }

    /**
     * Register a key binding.
     *
     * @param bind The key binding.
     */
    public void registerKeyEvent(KeyBinding bind) {

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(bind.getKeys()),
                bind.getNote()
        );

        this.getActionMap().put(
                bind.getNote(),
                bind.getAction()
        );
    }

    /**
     * Get the parent window - the one handling this screen.
     *
     * @return The window.
     */
    public Window getParentWindow() {
        return parentWindow;
    }

    /**
     * Set the parent window.
     *
     * @param parentWindow The parent window.
     */
    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }

    /**
     * Please refrain from using this.
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.repaint();
        super.paintComponent(g);
        render(g);
        try {
            Thread.sleep((long) RenderHelper.getRenderDelayForTargetFps(this.targetFps));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The render loop. Runs every time a frame is created.
     * @param g The graphic parameter.
     */
    public abstract void render(Graphics g);

    /**
     * The initiate method. Run only ONCE at class initialization.
     */
    public abstract void init();
}
