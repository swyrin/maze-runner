package Engine;

import java.awt.*;

/**
 * The render setting for the engine. NOT THE GAME SETTING.
 */
public class RenderSetting {
    /**
     * Target frames per second.
     */
    public static int maxFps = 24;

    /**
     * Whether to use AA.
     */
    public static boolean useAntiAliasing = true;

    /**
     * Whether to use Java's interpolation for rendering.
     */
    public static boolean useInterpolation = true;

    /**
     * What algorithm to use for interpolation.
     */
    public static Object interpolationChoice = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;

    /**
     * Name is self-explanatory.
     */
    public static boolean myPCSucks = false;
}
