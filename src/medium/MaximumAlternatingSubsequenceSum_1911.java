package medium;

import java.util.HashMap;

public class MaximumAlternatingSubsequenceSum_1911 {
    // https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/

    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 0) return 0L;
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum = sum - nums[i - 1] + nums[i];
            }
        }
        return sum;
    }

    class Solution {
        HashMap<String, Long> map = new HashMap<>();

        public long maxAlternatingSum(int[] nums) {
            return dfs(nums, 0, 0);
        }

        private long dfs(int[] nums, int index, int newIndex) {
            if (index == nums.length) return 0;
            String key = newIndex % 2 == 0 ? "+" : "-";
            key += index;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            long option1 = dfs(nums, index + 1, newIndex);
            long option2 = dfs(nums, index + 1, newIndex + 1);
            if (newIndex % 2 == 0)  {
                option2 += nums[index];
            } else {
                option2 -= nums[index];
            }
            long sum = Math.max(option1, option2);
            map.put(key, sum);
            return sum;
        }
    }
}
