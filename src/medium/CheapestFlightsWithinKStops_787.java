package medium;

import java.util.*;

public class CheapestFlightsWithinKStops_787 {


    // BFS - идем по уровням, и сохраняем минимальную цену
    // Мы никогда не дойдем дальше уровня k остановок, поэтому цены с большимии остановками никогда не будут записаны,
    // даже если они дешевле.
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) { // O(N)
            int from = flight[0];
            int to = flight[1];
            int weight = flight[2];
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new int[] {to, weight});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        int stops = k;
        while (stops-- >= 0)  {  // O(k)
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] head = queue.poll();
                int from = head[0];
                int curDist = head[1];
                for (int[] edge : adj.getOrDefault(from, new ArrayList<>())) { // O(E) , где E - макс количесто ребер
                    int newDist = curDist + edge[1];
                    if (newDist >= dist[edge[0]]) continue;
                    dist[edge[0]] = newDist;
                    queue.add(new int[]{edge[0], newDist});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        // Time: O(N) + O(E * K);
        // Space: O(E) + O(N) + O (E * K)
    }

    // Dijkstra
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;
        for (int[] flight : flights) {  // O(N)
            int from = flight[0];
            int to = flight[1];
            int weight = flight[2];
            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new int[]{to, weight});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((a) -> a[1]));
        queue.add(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            int from = head[0];
            int curDist = head[1];
            int step = head[2];
            if (step > stops[from] || step > k + 1) {
                continue;
            }
            stops[from] = step;
            if (from == dst) {
                return curDist;
            }
            if (!adj.containsKey(from)) continue;
            List<int[]> tos = adj.get(from);
            for (int[] edge : tos) { // O (E)
                queue.add(new int[]{edge[0], curDist + edge[1], step + 1});  // O(NlogN)
            }  // O(E * NlogN)
        }
        return -1;
        // Time O(N) + O(K * E * log(K * E))
        // Space O(E) + O(N) +  O(K * E)
    }

    //  Bellman-Ford
    public int findCheapestPriceBellman(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // O(N)
        dist[src] = 0;
        for (int i = 0; i <= k; i++) { // O(K)
            int[] temp = Arrays.copyOf(dist, n); //O (N)
            for (int[] flight : flights) { // O (E)
                int from = flight[0];
                int to = flight[1];
                int weight = flight[2];
                if (dist[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], dist[from] + weight);
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        // Time O(N) + O(K*(N + E))
    }
}
