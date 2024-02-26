/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Constants that decide various aspects of the engine.
*/

package Engine;

import java.awt.*;

/**
 * The render setting for the engine. NOT THE GAME SETTING.
 */
public class RenderSetting {
    /**
     * Target frames per second.
     */
    public static int maxFps = 80;

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
