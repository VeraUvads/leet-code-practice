package medium;

public class LongestPalindromicSubstring_5 {

    // https://leetcode.com/problems/longest-palindromic-substring/description/

    String res;

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        res = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            findLongest(i, i, s);
            findLongest(i, i + 1, s);
        }
        return res;
    }

    public void findLongest(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if (right - left + 1 > res.length()) {
            res = s.substring(left, right + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("cbbd"));
    }


    public static String longestPalindromeDP(String s) {
        if (s.isEmpty()) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        int answerStart = 0;
        int maxLength = 0;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    answerStart = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return s.substring(answerStart, answerStart + maxLength);
    }
}