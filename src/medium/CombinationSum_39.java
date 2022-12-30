package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    // https://leetcode.com/problems/combination-sum/?envType=study-plan&id=level-2

    List<List<Integer>> answer;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        answer = new ArrayList<>();
        tryCount(target, new LinkedList<Integer>(), 0);
        return answer;
    }

    public void tryCount(int remain, LinkedList<Integer> comb, int start) {
        if (remain == 0) {
            answer.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int current = candidates[i];
            comb.add(current);
            tryCount(remain - current, comb, i);
            comb.removeLast();
        }
    }
}
