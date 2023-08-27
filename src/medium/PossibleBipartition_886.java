package medium;

import java.util.*;

public class PossibleBipartition_886 {
// https://leetcode.com/problems/possible-bipartition/description/
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] people = new int[n + 1];
        HashMap<Integer, Set<Integer>> adj =  new HashMap<>();
        for (int[] dislike  : dislikes ) {
            adj.putIfAbsent(dislike[0], new HashSet<>());
            adj.get(dislike[0]).add(dislike[1]);
            adj.putIfAbsent(dislike[1], new HashSet<>());
            adj.get(dislike[1]).add(dislike[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int group =  -1;
        for (int i = 1; i <= n; i++)  {
            if (people[i] != 0) continue;
            queue.add(i);
            people[i] = group;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size != 0) {
                    int curr = queue.poll();
                    for (int neighbour : adj.getOrDefault(curr, new HashSet<>())) {
                        if (people[neighbour] == group) return false;
                        if (people[neighbour] != 0) continue;
                        people[neighbour] = -group;
                        queue.add(neighbour);
                    }
                    size--;
                }
                group *= -1;
            }
        }
        return true;
    }
}
