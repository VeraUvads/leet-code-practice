package medium;

public class NextPermutation_31 {
    // https://leetcode.com/problems/next-permutation/description/

    public void nextPermutation(int[] nums) {
        int sortFrom = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int biggerIndex = findFirstBiggerThan(nums, nums[i]);
                swap(nums, biggerIndex, i);
                sortFrom = i + 1;
                break;
            }
        }

        int left = sortFrom, end = nums.length - 1;
        while (left < end) {
            swap(nums, left++, end--);
        }
    }

    private int findFirstBiggerThan(int[] nums, int a) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > a) return i;
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
