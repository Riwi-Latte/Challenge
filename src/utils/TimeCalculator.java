// This file contains methods for calculating time differences, such as the duration of parking based on entry and exit times.

package utils;

import java.time.LocalTime;
import java.time.Duration;

public class TimeCalculator {

    public static long calculateParkingDuration(LocalTime entryTime, LocalTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        return duration.toHours() + (duration.toMinutes() % 60 > 0 ? 1 : 0); // Round up if there's any remaining minutes
    }
}