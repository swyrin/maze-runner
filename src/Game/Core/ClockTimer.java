/*
    Name: Group 11 from NH3-TTH2
    Members:
        Pham Tien Dat - ITITIU21172
        Do Tan Loc - ITCSIU21199
        Mai Xuan Thien - ITITIU21317
        Pham Quoc Huy - ITITIU21215
    Purpose: Just a timer, stop watch, something like that.
*/

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
