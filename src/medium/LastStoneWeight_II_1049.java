package medium;

import java.util.Arrays;

public class LastStoneWeight_II_1049 {
    // https://leetcode.com/problems/last-stone-weight-ii/description/

    public int lastStoneWeightII(int[] stones) {
        int total = Arrays.stream(stones).sum();
        int half = (total + 1)/ 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        int  closestToHalf = 0;
        for (int stone : stones) {
            for (int j = half; j >= stone; j--) {
                dp[j] |= dp[j - stone];
                if (dp[j]) {
                    closestToHalf = Math.max(closestToHalf, j);
                }
            }
        }
        return Math.abs((total - closestToHalf) - closestToHalf);
    }
}
