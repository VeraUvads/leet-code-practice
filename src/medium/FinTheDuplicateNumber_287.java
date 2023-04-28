package medium;

public class FinTheDuplicateNumber_287 {
    // https://leetcode.com/problems/find-the-duplicate-number/description/
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
