package medium;

import java.util.*;

public class Subsets_78 {
    // https://leetcode.com/problems/subsets/description/

    List<List<Integer>> answer = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        this.nums = nums;
        backtrack(curr, 0);
        return answer;
    }

    private void backtrack(List<Integer> curr, int index) {
        List<Integer> list = new ArrayList<>(curr);
        answer.add(list);
        if (curr.size() == nums.length) return;

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
