package medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_1509 {
    // int way1 = nums[right] - nums[left + 1]; // 11 - 4
    // int way2 = nums[right] - nums[left + 2]; // 11 - 5
    // int way3 = nums[right] - nums[left + 3]; // 11 - 10


    //// 1 : right
    //// 2 : right
    // 3 : right - considering only that case, because it always will be smaller than previous


    // int way12 = nums[right - 1] - nums[left]; // 10 - 0
    // int way22 = nums[right - 2] - nums[left]; // 5 - 0
    // int way32 = nums[riight - 3] - nums[left]; // 4 - 0

    // 0 : right - 3 -- same
    //// 0 : right - 2
    //// 0 : right - 1


    // int way13 = nums[right - 1] - nums[left  + 1]; // 10 - 0
    // int way23 = nums[right - 1] - nums[left + 2]; // 5 - 0
    // int way33 = nums[right - 2] - nums[left + 1]; // 4 - 0


    //// 1 : right - 1 - not considering that, cause it will be larger than two next
    // 2 : right - 1
    // 1 : right - 2



    // 0: right - 3 +
    // 1: right - 2 +
    // 2: right - 1;+
    // 3: right +


    public int minDifference(int[] nums) {
        int size = nums.length;
        if (size <= 4) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int left = 0, right = size - 4; right < size;) {
            min = Math.min(min, nums[right++] - nums[left++]);
        }
        return min;
    }
}
