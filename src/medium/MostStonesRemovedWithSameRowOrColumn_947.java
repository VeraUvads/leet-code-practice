package medium;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemovedWithSameRowOrColumn_947 {
    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/?envType=study-plan&id=level-2

    private boolean[] visited;
    private List<Integer>[] adj;

    public int removeStones(int[][] stones) {
        adj = new ArrayList[stones.length];
        for (int i = 0; i < stones.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (isCommonLine(stones[i], stones[j])){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        visited = new boolean[stones.length];
        int componentsCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i])  {
                dfs(i);
                visited[i] = true;
                componentsCount++;
            }
        }


        return stones.length - componentsCount;
    }

    private void dfs(int i) {
        if (!visited[i]) {
            visited[i] = true;
            for (int node : adj[i]) {
                dfs(node);
            }
        }
    }

    private boolean isCommonLine(int[] i, int[] j)  {
        return j[0] == i[0] || j[1] == i[1];
    }
}
