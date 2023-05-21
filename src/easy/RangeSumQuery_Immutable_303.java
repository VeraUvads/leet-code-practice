package easy;

public class RangeSumQuery_Immutable_303 {
    // https://leetcode.com/problems/range-sum-query-immutable/description/
    class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            if (nums.length == 0) return;
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
        // 1 2 3 4 5
        // 1 3 6 10 15
        // 2 - 4 == 3 + 4 + 5 == 12 == 15 - 3
    }
}
