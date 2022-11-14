package easy;

public class SearchInsertPosition_35 {

    // https://leetcode.com/problems/search-insert-position/description/

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = start + ((end - start) / 2);
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        System.out.println(searchInsert(array, 7));
    }

}
