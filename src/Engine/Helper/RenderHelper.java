package Engine.Helper;

public class RenderHelper {
    public static double getRenderDelayForTargetFps(int targetFps) {
        return 1000.0 / targetFps;
    }
}
