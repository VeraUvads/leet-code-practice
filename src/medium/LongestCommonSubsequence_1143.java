package medium;

public class LongestCommonSubsequence_1143 {
    // https://leetcode.com/problems/longest-common-subsequence/description/

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];
        for (int row = 1; row <= text2.length(); row++) {
            for (int col = 1; col < current.length; col++) {
                if (text2.charAt(row - 1) == text1.charAt(col - 1)) {
                    current[col] = previous[col - 1] + 1;
                } else {
                    current[col] = Math.max(current[col - 1], previous[col]);
                }
            }
            previous = current;
            current = new int[current.length];
        }
        return previous[previous.length - 1];
    }
}
