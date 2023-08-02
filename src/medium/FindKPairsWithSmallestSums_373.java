package medium;

import kotlin.Pair;

import java.util.*;

public class FindKPairsWithSmallestSums_373 {
    // https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        queue.add(new int[]{0, 0});
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        while (answer.size() != k && !queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            answer.add(Arrays.asList(nums1[i], nums2[j]));
            if (i + 1 < nums1.length && visited.add(new Pair<>(i + 1, j))) {
                queue.add(new int[]{i + 1, j});
            }
            if (j + 1 < nums2.length && visited.add(new Pair<>(i, j + 1))) {
                queue.add(new int[]{i, j + 1});
            }
        }
        return answer;
    }
}
