/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Helper class to serve with the Render
*/

package Engine.Helper;

public class RenderHelper {
    public static double getRenderDelayForTargetFps(int targetFps) {
        return 1000.0 / targetFps;
    }
}
