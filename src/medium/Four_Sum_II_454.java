package medium;

import java.util.HashMap;

public class Four_Sum_II_454 {
    // https://leetcode.com/problems/4sum-ii/description/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int counter = 0;
        if (n == 0) return 0;
        HashMap<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int firstSum = nums1[i] + nums2[j];
                counter += sums.getOrDefault(-firstSum, 0);
            }
        }
        return counter;
    }
}
