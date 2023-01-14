package medium;

public class MaximumSubarray_53 {
    // https://leetcode.com/problems/maximum-subarray/description/

    public int maxSubArrayDPOptimized(int[] nums) {
        if (nums.length == 0) return 0;
        int dp = nums[0];
        int ans = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            ans = Math.max(dp, ans);
        }
        return ans;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
