package medium;

public class New21Game_837 {
    // https://leetcode.com/problems/new-21-game/
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0|| n>=k+maxPts) return 1.0;
        double[] dp = new double[n + 1];
        double probability = 1.0;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = probability  / maxPts;
            if (i < k) probability += dp[i];

            if (i >= maxPts) probability -= dp[i  - maxPts];
        }
        double answer  =  0.0;
        for (int i = k; i <=n ; i++) answer += dp[i];
        return answer;
    }
}
