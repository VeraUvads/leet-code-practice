package hard;

public class WildcardMatching_44 {
    // https://leetcode.com/problems/wildcard-matching/description/?envType=featured-list&envId=top-interview-questions

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int row = 1; row < dp.length; row++) {
            char pChar = p.charAt(row - 1);
            if (pChar == '*') {
                dp[row][0] = dp[row - 1][0];
            }
            for (int col = 1; col < dp[row].length; col++) {
                char sChar = s.charAt(col - 1);
                if (sChar == pChar || pChar == '?') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (pChar == '*') {
                    dp[row][col] = dp[row - 1][col] || dp[row][col - 1];
                }
            }
        }
        return dp[m][n];
    }

}
