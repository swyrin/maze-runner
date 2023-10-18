package Engine.Core;

import javax.swing.*;

/**
 * A keyboard binding handler.
 */
public class KeyBinding {
    /**
     * Combination of key(s) to be used.
     * Of course, the natual language.
     */
    private final String keys;

    /**
     * The note for this key binding.
     * Simply answers "Why this one exists?"
     */
    private final String note;

    /**
     * The action to bind with this key binding.
     */
    private final Action action;

    /**
     * Create a key binding
     * @param note Why this one exists.
     * @param keys The keys to register
     * @param a The linked action.
     */
    public KeyBinding(String note, String keys, Action a) {
        this.note = note;
        this.keys = keys;
        this.action = a;
    }

    /**
     * Get the key binding note.
     * @return The note.
     */
    public String getNote() {
        return note;
    }

    /**
     * Get the keys of this binding.
     * @return The binding.
     */
    public String getKeys() {
        return keys;
    }

    /**
     * Get the action of this binding.
     * @return The action.
     */
    public Action getAction() {
        return action;
    }
}
