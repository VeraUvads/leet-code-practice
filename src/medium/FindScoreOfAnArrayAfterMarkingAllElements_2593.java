package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class FindScoreOfAnArrayAfterMarkingAllElements_2593 {
    // https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
    public long findScore(int[] nums) {
        int size = nums.length;

        int[][] arrayIndexed = new int[size][2];

        for (int i = 0; i < size; i++) {
            arrayIndexed[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arrayIndexed, Comparator.comparingInt(a -> a[0]));
        HashSet<Integer> marked = new HashSet<>();
        long answer = 0;
        for (int i = 0; i < size; i++) {
            int[] cur = arrayIndexed[i];
            long value = cur[0];
            int index = cur[1];
            if (marked.contains(index)) continue;
            answer += value;
            marked.add(index);
            marked.add(index + 1);
            marked.add(index - 1);
        }
        return answer;
    }
}
