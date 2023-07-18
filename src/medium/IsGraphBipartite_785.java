package medium;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
    // https://leetcode.com/problems/is-graph-bipartite/description/

    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[graph.length];
        int color = -1;
        for (int i = 0; i < graph.length; i++)  {
            if (colors[i] != 0) continue;
            queue.add(i);
            colors[i] = color;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    int curr = queue.poll();
                    for (int neighbour : graph[curr]) {
                        if (colors[neighbour] == color) return false;
                        if (colors[neighbour] != 0) continue;
                        colors[neighbour] = -color;
                        queue.add(neighbour);
                    }
                    size--;
                }
                color *= -1;
            }
        }
        return true;
    }
}
