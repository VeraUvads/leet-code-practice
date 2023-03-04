package medium;

import java.util.Arrays;
import java.util.Comparator;

public class CountWaysToGroupOverlappingRanges_2580 {
    // https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/

    int mod = 1000000007;
    public int countWays(int[][] ranges) { // [[1,3],[2,5],[4,8],[10,20]]
        Arrays.sort(ranges, Comparator.comparingInt((a) ->  a[0]));
        int groups = ranges.length;
        for (int i = 1; i < ranges.length; i++) {
            int[] prev = ranges[i - 1]; // 6, 10 -> 5, 15
            int[] cur = ranges[i];
            if (isOverlap(prev, cur)) {
                groups--;
                cur[0] = Math.min(prev[0], cur[0]);
                cur[1] = Math.max(prev[1], cur[1]);
            }
        }

        long answer = 1;
        while (groups != 0)  {
            answer = (answer * 2) % mod;
            groups--;
        }
        return (int) answer;
    }

    private boolean isOverlap(int[] prev, int[] cur) { // [1,3],[4,5]
        return Math.min(prev[1], cur[1]) - Math.max(prev[0], cur[0]) >= 0;
    }
}
