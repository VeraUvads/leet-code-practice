package medium;

public class MaximumProductSubarray_152 {
    // https://leetcode.com/problems/maximum-product-subarray/description/?envType=study-plan&id=level-2
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int min = nums[0];
        int max = nums[0];
        int result = max;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int b = num * min;
            int c = num * max;
            min = min(num, b, c);
            max = max(num, b, c);
            result = Math.max(result, max);
        }
        return result;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
