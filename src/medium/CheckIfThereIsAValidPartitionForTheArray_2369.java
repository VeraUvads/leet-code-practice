package medium;

public class CheckIfThereIsAValidPartitionForTheArray_2369 {
    // https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/
    class Solution1 {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i < n; i++) {
                int dpIndex = i + 1;
                if (nums[i] == nums[i - 1]) {
                    dp[dpIndex] |= dp[dpIndex - 2];
                }

                if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                    dp[dpIndex] |= dp[dpIndex - 3];
                }

                if (i > 1 && nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1) {
                    dp[dpIndex] |= dp[dpIndex - 3];
                }

            }
            return dp[n];
        }

    }
    class Solution2 {
        Boolean[] memo;
        public boolean validPartition(int[] nums) {
            memo = new Boolean[nums.length];
            return partite(nums, 0);
        }

        private boolean partite(int[] nums, int i) {
            if (i == nums.length) return true;
            if (memo[i] != null) return memo[i];
            boolean answer = false;

            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                answer |= partite(nums, i + 2);
            }

            if (i < nums.length - 2 && nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                answer |= partite(nums, i + 3);
            }

            if (i < nums.length - 2 && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1) {
                answer |= partite(nums, i + 3);
            }

            memo[i] = answer;
            return answer;
        }
    }
}
