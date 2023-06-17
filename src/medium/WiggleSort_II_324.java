package medium;

import java.util.Arrays;

public class WiggleSort_II_324 {

    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int index = nums.length - 1;
        // fill odd from biggest
        for (int i = 1; i < nums.length; i = i + 2) {
            nums[i] = sorted[index--];
        }
        // fill even
        for (int i = 0; i < nums.length; i = i + 2) {
            nums[i] = sorted[index--];
        }
    }
}
