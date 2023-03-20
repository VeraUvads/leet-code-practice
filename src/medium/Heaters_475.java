package medium;

import java.util.Arrays;

public class Heaters_475 {
    // https://leetcode.com/problems/heaters/description/
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            radius = Math.max(radius, getDistToHeater(heaters, house));
        }
        return radius;
    }

    private int getDistToHeater(int[] heaters, int house) {
        int radius = Integer.MAX_VALUE;
        int start = 0;
        int end = heaters.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            int dist = Math.abs(heaters[mid] - house);
            radius = Math.min(radius, dist);
            if (heaters[mid] >= house) {
                end = mid -  1;
            } else {
                start = mid + 1;
            }
        }
        return radius;
    }
}
