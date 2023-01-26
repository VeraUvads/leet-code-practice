package medium;

import java.util.Random;

public class KthLargestElementInAnArray_215 {
    // https://leetcode.com/problems/kth-largest-element-in-an-array/description/

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Random random = new Random();
        int left = 0;
        int right = len - 1;
        int kIndex = len - k;
        while (left < right) {
            int pivotIndex = left + random.nextInt(right - left);
            int pivot = nums[pivotIndex];
            swap(nums, pivotIndex, right);
            int storeIndex = left;
            for (int i = left; i <= right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, storeIndex, i);
                    storeIndex++;
                }
            }
            swap(nums, storeIndex, right);
            if (storeIndex == kIndex) return nums[storeIndex];
            if (storeIndex < kIndex) {
                left = storeIndex + 1;
            } else {
                right = storeIndex - 1;
            }
        }
        return nums[left];
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
