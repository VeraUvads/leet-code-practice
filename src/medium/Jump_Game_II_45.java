package medium;

import java.util.Arrays;

public class Jump_Game_II_45 {
    // https://leetcode.com/problems/jump-game-ii/description/

    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int prevMaxReached = 0;
        int curMaxReached = 0;
        int answer = 0;
        for (int i = 0; i < len - 1; i++) {
            curMaxReached = Math.max(i + nums[i], curMaxReached);
            if (prevMaxReached == i) {
                answer++;
                prevMaxReached = curMaxReached;
            }
        }
        return answer;
    }
    // 2 10 1 1 1
    //Cur  2 11 11
    //prev 2 1  11

    // 1 2 1 1 1
    // 0
    //mr   1 3


    public int jumpDp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len]; // O(n*m)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i] && i + j < len; j++) {
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }

        // 2 3 1 1 4
        // 0 1 1
        // dp[i + j]  = Math.min(dp[i] + 1, dp[i + j]);
        return dp[len - 1];
    }
}
