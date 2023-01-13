package medium;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    private int[] nums;
    private int target;
    private int[] ans = new int[] {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        binary(0, nums.length - 1);
        return ans;
    }

    private void binary(int left, int right) {
        if (right < left) return;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            ans[0] = ans[0] < 0 ? mid : Math.min(ans[0], mid);
            ans[1] = Math.max(ans[1], mid);
            binary(left, mid - 1);
            binary(mid + 1, right);
        } else if (nums[mid] < target) {
            binary(mid + 1, right);
        } else {
            binary(left, mid - 1);
        }
    }

}
