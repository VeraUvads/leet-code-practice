package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    // https://leetcode.com/problems/combination-sum-ii/

    int[] candidates;
    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        this.answer = new ArrayList<>();
        combine(new ArrayList<>(), 0, target);
        return answer;
    }

    private void combine(List<Integer> list, int start, int target) {
        if (target == 0) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++)  {
            int newTarget = target - candidates[i];
            if (newTarget < 0) continue;
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            combine(list, i + 1, newTarget);
            list.remove(list.size() - 1);
        }
    }
}
