package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends_1101 {
    // https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/

    class UnionFind {
        int[] parents;
        int groupCount;

        public UnionFind(int n) {
            parents = new int[n];
            groupCount = n;
            for (int i = 0; i <  n; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parents[parentX] = parentY;
                groupCount--;
            }
        }

        int find(int x) {
            if (parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a-> a[0]));
        UnionFind uf = new UnionFind(n);
        for (int[] log :logs) {
            int timestamp = log[0], a = log[1], b = log[2];
            uf.union(a, b);
            if (uf.groupCount  == 1) return timestamp;
        }
        return -1;
    }
}
