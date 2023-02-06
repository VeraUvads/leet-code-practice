package medium.not_finshed;

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces_547 {
    // https://leetcode.com/problems/number-of-provinces/?envType=study-plan&id=level-2

    // TODO need to solve UnionFind

    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        boolean[] visited  = new boolean[isConnected.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (!visited[j] && isConnected[node][j] == 1) {
                            queue.add(j);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }

}
