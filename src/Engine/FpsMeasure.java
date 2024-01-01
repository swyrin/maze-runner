/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: A Thread for measuring FPS (frames/second)
*/

package Engine;

public class FpsMeasure extends Thread {
    private double fps = 0;

    public void run() {
        while (true) {
            long lastTime = System.nanoTime();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            long now = System.nanoTime();
            fps = 1000000000.0 / (now - lastTime);

            lastTime = now;
        }
    }

    public double getFps() {
        return fps;
    }
}
