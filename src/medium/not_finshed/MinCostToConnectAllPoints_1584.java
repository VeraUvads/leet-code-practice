package medium.not_finshed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints_1584 {
    // https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=study-plan&id=level-3
    class UnionFind {
        int[] root;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] == x)  return x;
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

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        UnionFind uf = new UnionFind(points.length);

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1 ; j < points.length; j++) {
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
