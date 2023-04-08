package medium.not_finshed;

public class MaximumSubarray_53 {
    // https://leetcode.com/problems/maximum-subarray/description/
    int result = 0;

    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
