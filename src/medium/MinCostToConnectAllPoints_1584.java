package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints_1584 {
    // https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=study-plan&id=level-3

    // Lectures: https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3856/
    class SolutionKruskal {
        class UnionFind {
            int[] root;

            public UnionFind(int size) {
                root = new int[size];
                for (int i = 0; i < size; i++) {
                    root[i] = i;
                }
            }

            public int find(int x) {
                if (root[x] == x) return x;
                return root[x] = find(root[x]);
            }

            public void union(int a, int b) {
                int aRoot = find(a);
                int bRoot = find(b);
                if (aRoot == bRoot) return;
                root[aRoot] = bRoot;
            }

            public boolean isConnected(int a, int b) {
                return find(a) == find(b);
            }
        }

        public int minCostConnectPoints ( int[][] points){
        List<int[]> edges = new ArrayList<>();
        UnionFind uf = new UnionFind(points.length);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[0]));
        int result = 0;
        for (int[] edge : edges) {
            if (uf.isConnected(edge[1], edge[2])) continue;
            uf.union(edge[1], edge[2]);
            result += edge[0];
        }
        return result;
    }
    }
    class SolutionPrime {

        public int minCostConnectPoints(int[][] points) {
            if (points.length < 2) return 0;
            int size = points.length;
            boolean[] visited = new boolean[size];
            int[] first = points[0];
            visited[0] = true;
            size--;
            PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
            for (int i = 1; i < points.length; i++) {
                int[] second = points[i];
                int dist = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
                queue.add(new Edge(0, i, dist));
            }
            int result = 0;
            while (!queue.isEmpty() && size > 0) {
                Edge edge = queue.poll();
                if (visited[edge.second]) continue;
                visited[edge.second] = true;
                result += edge.dist;
                size--;
                first = points[edge.second];
                for (int i = 1; i < points.length; i++) {
                    if (visited[i]) continue;
                    int[] second = points[i];
                    int dist = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
                    queue.add(new Edge(0, i, dist));
                }
            }
            return result;
        }

        class Edge {
            int first;
            int second;
            int dist;

            public Edge(int first, int second, int dist) {
                this.first = first;
                this.second = second;
                this.dist = dist;
            }
        }
    }

    class SolutionPrimeOptimized {

        public int minCostConnectPoints(int[][] points) {
            if (points.length < 2) return 0;
            int edgeUsed = 0;
            int size = points.length;
            boolean[] visited = new boolean[size];
            int[] minDist = new int[size];
            for (int i = 1; i < points.length; i++) {
                minDist[i] = Integer.MAX_VALUE;
            }
            int result = 0;
            while (edgeUsed < points.length) {
                int currentMinEdge = Integer.MAX_VALUE;
                int currNode = -1;
                for (int i = 0; i < points.length; i++)  {
                    if (!visited[i] && currentMinEdge > minDist[i]) {
                        currentMinEdge = minDist[i];
                        currNode = i;
                    }
                }
                result += currentMinEdge;
                visited[currNode] = true;
                edgeUsed++;
                int[] first = points[currNode];
                for (int i = 1; i < points.length; i++) {
                    if (visited[i]) continue;
                    int[] second = points[i];
                    int dist = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
                    minDist[i] = Math.min(dist, minDist[i]);
                }
            }
            return result;
        }

    }
}
