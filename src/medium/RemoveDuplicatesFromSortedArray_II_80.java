package medium;

public class RemoveDuplicatesFromSortedArray_II_80 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        if (nums.length != k && nums[1] == nums[0]) k++;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] != nums[k - 1] || nums[i] == nums[k - 1] && nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
