package Engine.UI;

import Engine.Core.KeyBinding;

import javax.swing.*;

/**
 * The screen to be shown on the window.
 */
public class Screen extends JPanel {
    /**
     * The parent window handling this.
     */
    private Window parentWindow;

    /**
     * Register a key binding.
     *
     * @param bind The key binding.
     */
    public void registerKeyEvent(KeyBinding bind) {
        this.getInputMap().put(
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
}
