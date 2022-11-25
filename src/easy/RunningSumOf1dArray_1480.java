package easy;

public class RunningSumOf1dArray_1480 {
    // https://leetcode.com/problems/running-sum-of-1d-array/

    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
