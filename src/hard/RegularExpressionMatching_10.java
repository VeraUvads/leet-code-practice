package hard;

public class RegularExpressionMatching_10 {
    // https://leetcode.com/problems/regular-expression-matching/submissions/944405435/

    final  int TRUE = 1;
    final  int FALSE = 2;
    int[][] memo;

    String text;
    String pattern;;

    public boolean isMatchDP(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        this.text = s;
        this.pattern = p;
        return dp(0, 0);
    }

    private boolean dp(int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j] == TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean isMatch = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
            if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                ans = dp(i, j + 2) || isMatch && dp(i + 1, j);
            } else {
                ans = isMatch && dp(i + 1, j + 1);
            }
        }
        memo[i][j] = ans ? TRUE : FALSE;
        return memo[i][j] == TRUE;
    }



    public boolean isMatchRecursion(String s, String p) {
        return check(s, p);
    }

    private boolean check(String string, String pattern) {
        if (pattern.isEmpty()) return string.isEmpty();

        boolean isMatch = (!string.isEmpty() &&
                (pattern.charAt(0) == string.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            return isMatch && check(string.substring(1), pattern) || check(string, pattern.substring(2));
        }
        return isMatch && check(string.substring(1), pattern.substring(1));
    }



    public boolean isMatchDpTopDown(String text, String pattern) {
        boolean[][] dp = new boolean[pattern.length() + 1][text.length() + 1];
        dp[0][0] = true;
        for(int i=1;i<pattern.length(); i+=2){
            if(pattern.charAt(i)!='*') break;
            dp[i+1][0] = true;
        }
        for (int row = 1; row < dp.length; row++) {
            char pChar = pattern.charAt(row - 1);
            for (int col = 1; col < dp[row].length; col++) {
                char tChar = text.charAt(col - 1);
                if (pChar == tChar || pChar == '.') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (pChar == '*') {
                    dp[row][col] = dp[row - 2][col] || dp[row][col - 1] && (tChar == pattern.charAt(row - 2) || pattern.charAt(row - 2) == '.') || dp[row - 1][col];
                }
            }
        }
        return dp[pattern.length()][text.length()];
    }
}
