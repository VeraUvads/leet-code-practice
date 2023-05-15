package medium;

import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
    // https://leetcode.com/problems/longest-consecutive-sequence/description/

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStrike = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentStrike = 0;
                while (set.contains(num++)) {
                    currentStrike++;
                }
                longestStrike = Math.max(longestStrike, currentStrike);
            }
        }
        return longestStrike;
    }
}
