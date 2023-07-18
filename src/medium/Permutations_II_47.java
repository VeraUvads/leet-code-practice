package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations_II_47 {
    // https://leetcode.com/problems/permutations-ii/description/
    private List<List<Integer>> answer;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        reorder(list, 0);
        return answer;
    }

    private void reorder(List<Integer> seq, int start) {
        if (start == seq.size() - 1) {
            answer.add(new ArrayList<>(seq));
            return;
        }
        for (int i = start; i < seq.size(); i++) {
            if (i != start && seq.get(start) == seq.get(i)) continue;
            if (i != start && i != 0 && seq.get(i - 1) == seq.get(i)) continue;
            Collections.swap(seq, start, i);
            reorder(seq, start + 1);
            Collections.swap(seq, start, i);
        }
    }
}
