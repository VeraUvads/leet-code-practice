package medium;

public class FindTheDivisibilityArrayOfAString_2575 {
    // https://leetcode.com/contest/weekly-contest-334/problems/find-the-divisibility-array-of-a-string/

    public int[] divisibilityArray(String word, int m) {
        int[] dp = new int[word.length()];
        long digitSum = 0;
        for (int i = 0; i < word.length(); i++) {
            digitSum = digitSum * 10 + word.charAt(i) - '0';
            if (digitSum % m == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
            digitSum %= m;
        }
        return dp;
    }
}
