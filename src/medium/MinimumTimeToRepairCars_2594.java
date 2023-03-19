package medium;

import java.util.Arrays;

public class MinimumTimeToRepairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        if (ranks.length == 0) return 0;
        long min = 1;
        long max =  Arrays.stream(ranks).min().getAsInt() * (long)  Math.pow(cars, 2);
        long maxTime = max;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (repairedCar(mid, ranks) >= cars) {
                max = mid - 1;
                maxTime = Math.min(maxTime, mid);
            } else {
                min = mid + 1;
            }
        }
        return maxTime;
    }

    private long repairedCar(long time, int[] ranks) {
        long count = 0;
        for (int i = 0; i < ranks.length; i++)  {
            count += (int) Math.sqrt(time/ ranks[i]);
        }
        return count;
    }
}
