/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: A task to draw the frame(s) when needed.
*/
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
        while (!this.screenToRender.isOnDemandRender() && !this.isInterrupted) {
            this.screenToRender.repaint();
        }
    }

    public void cancel() {
        isInterrupted = true;
    }
}
