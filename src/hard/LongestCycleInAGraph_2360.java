package hard;

import java.util.LinkedList;
import java.util.Queue;

public class LongestCycleInAGraph_2360 {
    // https://leetcode.com/problems/longest-cycle-in-a-graph/description/

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];
        int[] neighbours = new int[n];
        for (int i = 0; i < n; i++) {
            int from = i;
            int to = edges[i];
            neighbours[from] = to;
            if (to != -1) {
                indegree[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            int neighbour = neighbours[cur];
            if (neighbour == -1) continue;
            indegree[neighbour]--;
            if (indegree[neighbour] == 0) {
                queue.add(neighbour);
            }
        }
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int neighbour = neighbours[i];
                int count = 1;
                while (neighbour != i) {
                    if (neighbour == -1) break;
                    visited[neighbour] = true;
                    neighbour = neighbours[neighbour];
                    count++;
                }
                if (neighbour == i) {
                    answer = Math.max(answer, count);
                }
            }
        }
        return answer;
    }
}
