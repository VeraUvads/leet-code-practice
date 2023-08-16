package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DetonateTheMaximumBombs_2101 {
    // https://leetcode.com/problems/detonate-the-maximum-bombs/
    HashMap<Integer, List<Integer>> adj = new HashMap<>();

    public int maximumDetonation(int[][] bombs) {
        for (int i = 0; i < bombs.length; i++) {
            int[] bomb1 = bombs[i];
            long radius1 =  bomb1[2] ;
            for (int  j = i + 1; j < bombs.length; j++) {
                int[] bomb2 = bombs[j];
                long radius2 = bomb2[2];
                long dX = bomb1[0] - bomb2[0];
                long dY = bomb1[1] - bomb2[1];
                long form = (long)dX * dX + (long)dY * dY;
                if (form <= radius1 * radius1) {
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.get(i).add(j);
                }
                if (form <= radius2 * radius2) {
                    adj.putIfAbsent(j, new ArrayList<>());
                    adj.get(j).add(i);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            int affect = dfs(i, new HashSet<>());
            max  = Math.max(max, affect);
        }
        return max;
    }

    private int dfs(int currentNode, HashSet<Integer> visited) {
        visited.add(currentNode);
        int counter = 1;
        for (int neighbour : adj.getOrDefault(currentNode, new ArrayList<>())) {
            if (visited.add(neighbour)) {
                counter += dfs(neighbour, visited);
            }
        }
        return counter;
    }
}
