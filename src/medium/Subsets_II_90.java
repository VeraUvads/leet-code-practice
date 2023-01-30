package medium;

import java.util.*;

public class Subsets_II_90 {
    // https://leetcode.com/problems/subsets-ii/?envType=study-plan&id=level-3

    private final Set<List<Integer>> answer = new HashSet<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return new ArrayList<>(answer);
    }

    private void backtrack(List<Integer> set, int start) {
        answer.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(set, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
