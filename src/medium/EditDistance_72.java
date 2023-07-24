package medium;

public class EditDistance_72 {
    // https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=top-interview-150

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int row = 0; row < dp.length; row++) dp[row][0] = row;
        for (int col = 0; col < dp[0].length; col++) dp[0][col] = col;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++)  {
                char first = word1.charAt(i - 1);
                char second = word2.charAt(j - 1);
                if (first == second) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
