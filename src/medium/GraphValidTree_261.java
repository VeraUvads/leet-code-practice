package medium;

public class GraphValidTree_261 {
    // https://leetcode.com/problems/graph-valid-tree/description/
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) { // N
            if (uf.isConnected(edge[0], edge[1])) return false; // a(N)
            uf.union(edge[0], edge[1]);
        }
        return true;
    }

    static class UnionFind {
        int[] root;
        int groupCount;

        public UnionFind(int size) {
            root = new int[size];
            groupCount = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) return;
            root[parentY] = parentX;
            groupCount--;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
