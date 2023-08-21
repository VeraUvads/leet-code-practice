package medium;

public class TossStrangeCoins_1230 {
    // https://leetcode.com/problems/toss-strange-coins/description/

    public double probabilityOfHeads(double[] probs, int target) {
        if (target > probs.length) return 0.0;
        if (probs.length == 0) return target == 0 ? 1.0 : 0.0;
        double[][] dp = new double[probs.length + 1][target + 1];
        dp[0][0] = 1.0;
        for (int i = 1; i < dp.length; i++){
            double prob = probs[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] += dp[i-1][j]  * (1 - prob);
                if (j > 0)  {
                    dp[i][j] += dp[i-1][j - 1]  * prob;
                }
            }
        }

        return dp[probs.length][target];
    }

    class Solution {
        Double[][] memo;
        public double probabilityOfHeads(double[] probs, int target) {
            if (target > probs.length) return 0.0;
            if (probs.length == 0) return target == 0 ? 1.0 : 0.0;
            memo = new Double[probs.length + 1][target + 1];
            return dfs(probs, target, 0);
        }

        private double dfs(double[] probs, int target, int index) {
            if (index == probs.length) return target == 0 ? 1.0 : 0.0;
            if (target < 0) return 0.0;
            if (memo[index][target] != null) return memo[index][target];
            double head = dfs(probs, target - 1, index + 1)* probs[index];
            double bottom = dfs(probs, target, index + 1) * (1.0 - probs[index]);
            double result = head + bottom;
            memo[index][target]  = result;
            return result;
        }
    }
}
