package easy;

public class MinCostClimbingStairs_746 {
    // https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan&id=level-1

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
