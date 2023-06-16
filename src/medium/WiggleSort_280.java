package medium;

import java.util.Arrays;

public class WiggleSort_280 {
    // https://leetcode.com/problems/wiggle-sort/description/

    public void wiggleSortOptimal(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            } else {
                if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
            }
        }
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i = i + 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
