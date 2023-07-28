package medium;

import java.util.HashMap;

public class MaxNumberOfKSumPairs_1679 {
    // https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) != 0) {
                counter++;
                map.put(k - num, map.get(k - num) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return counter;
    }
}
