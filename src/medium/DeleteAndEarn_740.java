package medium;

import java.util.HashMap;

public class DeleteAndEarn_740 {
    // https://leetcode.com/problems/delete-and-earn/description/

    // 2,2,3,3,3,4
    // + +
    // 2 4 3 6 9 (9 || 4 + 4)


    // [3,4,2]
    // 2 3 4
    // 2 3 (3 ||2 + 4)
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        HashMap<Integer, Integer> points= new HashMap<>();
        int biggest = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            biggest = Math.max(biggest, num);
        }
        int[] dp = new int[biggest + 1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1, 0);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points.getOrDefault(i, 0));
        }
        return dp[dp.length - 1];
    }
}
