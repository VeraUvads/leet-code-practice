package medium;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCitiesWithMinimumCost_1135 {
    // https://leetcode.com/problems/connecting-cities-with-minimum-cost/description/

    class UnionFind{
        int[] root;
        int groups;
        public UnionFind(int n ) {
            groups  =  n;
            root = new int[n + 1];
            for (int i = 0; i <=n; i++)  root[i] = i;

        }

        private int find(int a) {
            if (root[a] == a) return a;
            return root[a] = find(root[a]);
        }

        private void connect(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) return;
            root[parentB] = parentA;
            groups--;
        }

        private boolean isConnected(int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            return parentA == parentB;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a-> a[2]));
        UnionFind uf = new UnionFind(n);
        int sum = 0;
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            if (uf.isConnected(a, b)) continue;
            uf.connect(a, b);
            sum += connection[2];
        }
        return uf.groups == 1 ? sum : -1;
    }
}
