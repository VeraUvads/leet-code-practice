package easy;

import java.util.Arrays;

public class MaximizeGreatnessOfAnArray_2592 {
    // https://leetcode.com/problems/maximize-greatness-of-an-array/
    public int maximizeGreatness(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        int counter = 0;
        for (int left = 0, right = 1; right < size; right++) {
            if (nums[right] > nums[left]) {
                counter++;
                left++;
            }
        }
        return counter;
    }
}
