package Game.Core;

import java.time.Duration;
import java.time.Instant;

public class ClockTimer {
    private static Instant startTime, endTime;

    public static void start() {
        startTime = Instant.now();
    }

    public static void stop() {
        endTime = Instant.now();
    }

    public static Duration getElapsedTime() {
        Instant currentEndTime = endTime == null ? Instant.now() : endTime;

        return Duration.between(startTime, currentEndTime);
    }
}
