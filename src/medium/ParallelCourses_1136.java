package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelCourses_1136 {
    // https://leetcode.com/problems/parallel-courses/

    public int minimumSemesters(int n, int[][] relations) { // [prevCoursei, nextCoursei]
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            HashSet<Integer> nexts = adj.getOrDefault(prev, new HashSet<>());
            nexts.add(next);
            adj.put(prev, nexts);
        }
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!adj.containsKey(i)) continue;
            HashSet<Integer> nexts = adj.get(i);
            for (int next : nexts) {
                inDegree[next]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int semesters = 0;
        int nodes = n;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int curr = queue.poll();
                nodes--;
                for (int next : adj.getOrDefault(curr, new HashSet<>())) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    } else if (inDegree[next] < 0) {
                        return -1;
                    }
                }
                size--;
            }
            semesters++;
        }
        if (nodes != 0) return -1;
        return semesters;
    }
}
