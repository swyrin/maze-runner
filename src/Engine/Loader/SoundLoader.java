package Engine.Loader;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The sound player.
 */
public class SoundLoader {
    /**
     * The associated audio clip.
     */
    private Clip clip;

    /**
     * Loop status.
     */
    private boolean loop;

    /**
     * Create a player with custom loop status.
     *
     * @param path Path of the audio file.
     * @param loop Is loop needed?
     */
    public SoundLoader(final String path, boolean loop) {
        this(path);
        this.loop = loop;
    }

    /**
     * Create a player with loop off.
     *
     * @param path Path of the audio file.
     */
    public SoundLoader(final String path) {
        try {
            this.clip = AudioSystem.getClip();
            this.loop = false;

            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    new BufferedInputStream(Files.newInputStream(Paths.get(path))));

            getClip().open(inputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ignored) {
        }
    }

    /**
     * Get the audio associated with this player.
     *
     * @return The audio clip.
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Get loop status.
     *
     * @return Loop status.
     */
    public boolean getLoop() {
        return loop;
    }

    /**
     * Starts the player.
     * Thread safety is guaranteed.
     */
    public synchronized void start() {
        new Thread(() -> {
            try {
                if (getLoop()) getClip().loop(Clip.LOOP_CONTINUOUSLY);
                getClip().start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }

    /**
     * Stops the player.
     * Thread safety is guaranteed.
     */
    public synchronized void stop() {
        new Thread(() -> {
            try {
                getClip().stop();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }).start();
    }
}