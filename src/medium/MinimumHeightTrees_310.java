package medium;

import java.util.*;

public class MinimumHeightTrees_310 {
    // https://leetcode.com/problems/minimum-height-trees/description/

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        if (n < 2) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj.putIfAbsent(from, new HashSet<>());
            adj.get(from).add(to);

            adj.putIfAbsent(to, new HashSet<>());
            adj.get(to).add(from);
        }
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                Integer parent = adj.get(leaf).iterator().next();
                Set<Integer> curr = adj.get(parent);
                curr.remove(leaf);
                if (curr.size() == 1) {
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
