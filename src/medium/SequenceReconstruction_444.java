package medium;

import java.util.*;

public class SequenceReconstruction_444 {
    // https://leetcode.com/problems/sequence-reconstruction/description/
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indegree = new int[n + 1];
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> sequence : sequences) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                int curr = sequence.get(i);
                int next = sequence.get(i + 1);
                graph.get(curr).add(next);
                indegree[next]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (indegree[num] == 0) {
                queue.add(num);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int curr = queue.poll();
            for (int neib : graph.get(curr)) {
                indegree[neib]--;
                if (indegree[neib] == 0) queue.add(neib);
            }
        }
        return true;
    }
}
