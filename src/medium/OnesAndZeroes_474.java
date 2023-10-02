package medium;

public class OnesAndZeroes_474 {
// https://leetcode.com/problems/ones-and-zeroes/
public int findMaxForm(String[] strs, int zeroes, int ones) {
    int[][] dp = new int[zeroes + 1][ones + 1];
    for (int i = 0; i < strs.length; i++) {
        int[] counted = countOnesZeroes(strs[i]);
        int countedZeroes = counted[0], countedOnes = counted[1];
        for (int zero = zeroes; zero >= countedZeroes; zero--)  {
            for (int one = ones; one >= countedOnes; one--) {
                int curr = dp[zero - countedZeroes][one - countedOnes] + 1;
                dp[zero][one] = Math.max(dp[zero][one], curr);
            }
        }
    }

    // ["10","0001","111001","1","0"]
    //   0 1 2 3 4 5  - zeros 1 zeroes 1 ones
    // 0 0 0 0 0 0 0
    // 1 0 1 0 0 0 0
    // 2 0 0 0 0 0 0
    // 3 0 0 0 0 0 0
    // Ones

    return dp[zeroes][ones];
}

    private int[] countOnesZeroes(String str) {
        int zeroes = 0, ones = 0;
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (symbol == '0') zeroes++;
            else ones++;
        }
        return new int[]{zeroes, ones};
    }
}
