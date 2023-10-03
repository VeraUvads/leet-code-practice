package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountVisitedNodesInADirectedGraph_2876 {
    // https://leetcode.com/problems/count-visited-nodes-in-a-directed-graph/description/
    HashMap<Integer, Integer> memo = new HashMap<>();
    List<Integer> edges;
    int[] answer;
    HashSet<Integer> visited = new HashSet<>();

    public int[] countVisitedNodes(List<Integer> edges) {
        this.edges = edges;
        this.answer = new int[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            answer[i] = dfs(i, 0);
        }
        return answer;
    }

    private int dfs(int current, int depth) {
        if (memo.containsKey(current)) return memo.get(current);
        if (!visited.add(current)) {
            int cycleLength = cycleLength(current, edges.get(current));
            updateCycle(current, edges.get(current), cycleLength);
            return 0;
        }
        int result = dfs(edges.get(current), depth + 1) + 1;
        if (!memo.containsKey(current)) memo.put(current, result);
        return memo.get(current);
    }

    private int cycleLength(int target, int current) {
        if (target == current) return 1;
        return cycleLength(target, edges.get(current)) + 1;
    }

    private void updateCycle(int target, int current, int length) {
        memo.put(current, length);
        if (target == current) return;
        updateCycle(target, edges.get(current), length);
    }
}
