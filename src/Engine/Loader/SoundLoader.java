/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Class dedicated to playback of the sound.
*/

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

            this.clip.open(inputStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ignored) {
        }
    }

    /**
     * Starts the player.
     */
    public void start() {
        if (this.loop) this.clip.loop(Clip.LOOP_CONTINUOUSLY);
        this.clip.start();
    }

    /**
     * Stops the player.
     */
    public void stop() {
        if (this.loop) this.clip.loop(0);
        this.clip.stop();
    }
}