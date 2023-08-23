package medium;

public class PalindromicSubstrings_647 {
    // https://leetcode.com/problems/palindromic-substrings/description/

    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            answer++;
        }

        for (int i = 0; i < n - 1; i++) {
            char symbol1 = s.charAt(i);
            char symbol2 = s.charAt(i + 1);
            boolean isEqual = symbol1 == symbol2;
            dp[i][i + 1] = isEqual;
            dp[i + 1][i] = isEqual;
            if (isEqual) answer++;
        }

        for (int len = 2; len < n; len++) { // len < n - 1?
            for (int i = 0; i < n - len;  i++) {
                char symbol1 = s.charAt(i);
                char symbol2 = s.charAt(i + len);
                boolean isEqual = symbol1 == symbol2;
                boolean isPalindrom = isEqual && dp[i + 1][i + len - 1];
                dp[i][i + len] = isPalindrom;
                dp[i + len][i] = isPalindrom;
                if (isPalindrom) answer++;
            }

        }
        return answer;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int count1 = expandAroundCenter(s, i, i);
            int count2 = expandAroundCenter(s, i, i + 1);
            answer+= count1;
            answer+= count2;
        }
        return answer;
    }

    private int expandAroundCenter(String string, int left, int right) {
        int counter = 0;
        while (left >= 0 && right < string.length()) {
            if (string.charAt(left--) != string.charAt(right++)) return counter;
            counter++;
        }
        return counter;
    }
}
