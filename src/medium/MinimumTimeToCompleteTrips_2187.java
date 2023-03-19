package medium;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips_2187 {
    // https://leetcode.com/problems/minimum-time-to-complete-trips/description/

    public long minimumTime(int[] time, int totalTrips) {
        long min = 1;
        long fastestTimeForBus =  Arrays.stream(time).min().getAsInt();
        long max = fastestTimeForBus * totalTrips;
        long minTime = max;
        while (min < max) {
            long mid = (max + min) / 2;
            if (completedTrips(mid, time) >= totalTrips)  {
                max = mid;
                minTime = Math.min(minTime, mid);
            } else {
                min = mid + 1;
            }
        }
        return minTime;
    }

    private long completedTrips(long time, int[] times) {
        long trips = 0;
        for (int j : times) {
            trips += time / j;
        }
        return trips;
    }
}
