package medium;

import java.util.Arrays;

public class TargetSum_494 {
    // https://leetcode.com/problems/target-sum/description/
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] dp  = new int[nums.length][total * 2 + 1];
        dp[0][nums[0] + total] += 1;
        dp[0][-nums[0] + total] += 1;

        for (int row = 1; row < dp.length; row++) {
            for (int sum = -total; sum <= total; sum++) {
                if (dp[row - 1][sum + total] > 0) {
                    dp[row][sum + nums[row] + total] += dp[row - 1][sum + total];
                    dp[row][sum - nums[row] + total] += dp[row - 1][sum + total];
                }
            }
        }

        return Math.abs(target) > total ? 0 : dp[dp.length - 1][target + total];
    }

}
