package medium;

public class SearchInRotatedSortedArray_33 {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middle = nums[middleIndex];
            if (middle == target) {
                return middleIndex;
            } else if (middle >= nums[start]) {
                if (target >= nums[start] && target < middle) {
                    end = middleIndex - 1;
                }  else {
                    start = middleIndex + 1;
                }
            } else {
                if (middle < target && target <= nums[end]) {
                    start = middleIndex + 1;
                } else {
                    end = middleIndex - 1;
                }
            }
        }
        return -1;
    }
}
