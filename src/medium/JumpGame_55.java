package medium;

public class JumpGame_55 {
    // https://leetcode.com/problems/jump-game/description/

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIndex = 0;
        // tracking maxReachable point
        // if current index less than maxIndex - false
        for (int i = 0; i < len; i++)  {
            if (maxIndex < i) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
