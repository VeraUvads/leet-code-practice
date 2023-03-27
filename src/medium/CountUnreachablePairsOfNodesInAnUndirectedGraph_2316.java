package medium;

import java.util.HashMap;
import java.util.Map;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph_2316 {
    // https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

    static class UnionFind {
        int[] root;
        int groupCount;

        public UnionFind(int size) {
            this.root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            if (isConnected(x, y)) return;
            int xParent = find(x);
            int yParent = find(y);
            root[xParent] = yParent;
            groupCount--;
        }
    }
    /*
        4 * 2  + 2 * 1  + 4 * 1
     */


    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            int size = map.getOrDefault(parent, 0);
            map.put(parent, size + 1);
        }
        int remainingNodes = n;
        long result = 0;
        for (Map.Entry<Integer,  Integer> entry : map.entrySet()) {
            int size = entry.getValue();
            result +=  (long) size * (remainingNodes - size);
            remainingNodes -= size;
        }
        return result;
    }
}
