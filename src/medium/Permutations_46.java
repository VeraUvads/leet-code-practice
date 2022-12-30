package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations_46 {
    // https://leetcode.com/problems/permutations/description/?envType=study-plan&id=level-2
    private List<List<Integer>> answer;

    public List<List<Integer>> permute(int[] nums) {
        this.answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        reorder(list, 0);
        return answer;
    }

    private void reorder(List<Integer> seq, int start) {
        if (start == seq.size()) {
            answer.add(new ArrayList<>(seq));
        }
        for (int i = start; i < seq.size(); i++) {
            Collections.swap(seq, start, i);
            reorder(seq, start + 1);
            Collections.swap(seq, start, i);
        }
    }
}
