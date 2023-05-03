package medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray_384 {
    // https://leetcode.com/problems/shuffle-an-array/description/

    private int[] initialArray;
    private int[] nums;
    private Random random;

    public ShuffleAnArray_384(int[] nums) {
        this.nums = nums;
        this.initialArray = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }

    public int[] reset() {
        this.nums = Arrays.copyOf(initialArray, nums.length);
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int newIndex = i + random.nextInt(n - i);
            swap(nums, i, newIndex);
            // swap(nums, newIndex, newIndex);
        }
        return nums;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
