package medium;

import java.util.HashMap;
import java.util.Map;

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



    // Follow-up: kSum
    int[][] nums;

    public int kSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1.length == 0) return 0;
        int counter = 0;
        nums = new int[][]{nums1, nums2, nums3, nums4};
        int k = nums.length;

        HashMap<Integer, Integer> left = kSum(0, k / 2);
        HashMap<Integer, Integer> right = kSum(k / 2, k);

        for (Map.Entry<Integer, Integer> entry : left.entrySet()) {
            System.out.println(entry.getKey());
            int firstCount = entry.getValue();
            int secondCount = right.getOrDefault(-entry.getKey(), 0);
            counter += firstCount * secondCount;
        }
        return counter;
    }

    private HashMap<Integer, Integer> kSum(int start, int end) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        for (int i = start; i < end; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums[i]) {
                for (int total : sums.keySet()) {
                    int sum = total + num;
                    map.put(sum, map.getOrDefault(sum, 0) + sums.get(total));
                }
            }
            sums = map;
        }
        return sums;
    }

}
