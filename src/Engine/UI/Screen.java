package Engine.UI;

import Engine.FpsMeasure;
import Engine.Helper.RenderHelper;
import Engine.RenderSetting;
import Engine.Renderer;

import javax.swing.*;
import java.awt.*;

/**
 * The screen to be shown on the window.
 * Please note this is just the basic screen, extension is ill-advised.
 */
public abstract class Screen extends JPanel {
    /**
     * The FPS counter thread.
     */
    protected final FpsMeasure fpsMeasure;

    /**
     * The task in task of rendering.
     */
    private final Renderer renderer;

    /**
     * The thread in charge of the rendering.
     */
    private final Thread renderThread;
    /**
     * Target fps for this screen.
     */
    private final int targetFps;
    /**
     * Should this screen be rendered per "repaint()" call or render indefinitely.
     */
    private boolean onDemandRender;
    /**
     * The parent window handling this.
     */
    private Window parentWindow;


    /**
     * Create the screen with the desired fps.
     *
     * @param targetFps The desired fps.
     */
    public Screen(int targetFps) {
        this.setDoubleBuffered(true);

        this.onDemandRender = false;
        this.targetFps = targetFps;
        this.fpsMeasure = new FpsMeasure();
        this.renderer = new Renderer(this);
        this.renderThread = new Thread(this.renderer);
    }

    /**
     * Create the screen with the default settings.
     */
    public Screen() {
        this(RenderSetting.maxFps);
    }

    /**
     * Where this screen is an on-demand render screen.
     *
     * @param onDemandRender the flag.
     */
    public void setOnDemandRender(boolean onDemandRender) {
        this.onDemandRender = onDemandRender;
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

    public Thread getRenderThread() {
        return renderThread;
    }

    /**
     * Please refrain from using this. Use {@link #render(Graphics2D) render} method instead.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (RenderSetting.myPCSucks) {
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        }

        if (RenderSetting.useInterpolation) {
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderSetting.interpolationChoice);
        }

        if (RenderSetting.useAntiAliasing) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        try {
            render(g2d);
            this.fpsMeasure.interrupt();
            Thread.sleep((long) RenderHelper.getRenderDelayForTargetFps(this.targetFps));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Make the screen visible, and start rendering.
     *
     * @param aFlag true to make the component visible; false to make it invisible
     */
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);

        try {
            if (!this.onDemandRender) {
                this.renderThread.start();
                this.fpsMeasure.start();
            }
        } catch (IllegalThreadStateException ex) {
            // fuck you.
        }
    }

    /**
     * Dispose the running screen. Meant to be replaced with another screen.
     */
    public void dispose() {
        if (this.renderThread.isAlive()) this.renderThread.interrupt();
        if (this.fpsMeasure.isAlive()) this.fpsMeasure.interrupt();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    /**
     * The render loop. Runs every time a frame is created.
     *
     * @param g2d The graphic parameter.
     */
    public abstract void render(Graphics2D g2d);

    /**
     * The initiate method. Run only ONCE at class initialization.
     */
    public abstract void init();
}
