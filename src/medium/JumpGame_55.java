package medium;

public class JumpGame_55 {
    // https://leetcode.com/problems/jump-game/description/

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int maxIndex = 0;
        for (int i = 0; i < len; i++)  {
            if (maxIndex < i) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
