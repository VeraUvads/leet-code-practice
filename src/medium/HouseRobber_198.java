package medium;

public class HouseRobber_198 {

    public int robOptimized(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int nextPlusOne = 0;
        int next = nums[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            int current = Math.max(nextPlusOne + nums[i], next);
            nextPlusOne = next;
            next = current;
        }
        return next;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[len - 1] = nums[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+2] + nums[i], dp[i+1]);
        }
        return dp[0];
    }
}
