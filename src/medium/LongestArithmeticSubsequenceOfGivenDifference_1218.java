package medium;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference_1218 {
    // https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int a: arr) {
            int beforeA = map.getOrDefault(a - difference, 0);
            map.put(a, beforeA + 1);
            max = Math.max(max, beforeA + 1);
        }
        return max;
    }
}
