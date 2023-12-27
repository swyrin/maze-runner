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
