package easy;

// ://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int k = 1;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (previous != current) {
                nums[k] = current;
                k++;
                previous = current;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
    }
}
