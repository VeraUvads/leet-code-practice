package medium;

import javafx.util.Pair;

import java.util.*;

public class NetworkDelayTime_743 {
    // https://leetcode.com/problems/network-delay-time/description/
    private HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int dist = time[2];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new Pair<>(dist, to));
        }

        int[] minDist = new int[n + 1];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[k] = 0;

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getKey)
        );
        queue.add(new Pair<>(0, k));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int currTime = pair.getKey();
            int from = pair.getValue();
            if (!map.containsKey(from)) continue;
            if (currTime > minDist[from]) continue;

            for (Pair<Integer, Integer> edge : map.get(from)) {
                int to = edge.getValue();
                int dist = edge.getKey() + currTime;
                if (dist < minDist[to]) {
                    minDist[to] = dist;
                    queue.add(new Pair<>(dist, to));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(minDist[i], result);
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }
}
