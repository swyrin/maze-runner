package Engine;

import Engine.UI.Screen;

public class Renderer implements Runnable {
    private final Screen screenToRender;
    private boolean isInterrupted = false;

    public Renderer(Screen s) {
        this.screenToRender = s;
    }

    @Override
    public void run() {
        while (!this.isInterrupted) {
            this.screenToRender.repaint();
        }
    }

    public void cancel()
    {
        isInterrupted = true;
    }
}
