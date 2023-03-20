package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    // https://leetcode.com/problems/longest-increasing-subsequence/description/

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int left = 0; left < size; left++) {
            for (int right = left + 1; right < size; right++) {
                if (nums[left] < nums[right]) {
                    dp[right] = Math.max(dp[left] + 1, dp[right]);
                    max = Math.max(max, dp[right]);
                }
            }
        }
        return max;
    }
}
