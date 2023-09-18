package hard;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands_II_305 {
    // https://leetcode.com/problems/number-of-islands-ii/description/
    class UnionFind {
        int[] root;
        int n;
        int m;
        int groups = 0;
        public UnionFind(int n,  int m) {
            this.n = n;
            this.m = m;
            int size = n * m;
            this.root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = -1;
            }
        }

        void addGroup(int row, int col) {
            int curr = row * m + col;
            if (root[curr] >= 0) return;

            root[curr] = curr;
            groups++;
            if (row > 0) {
                int up = (row - 1) * m + col;
                union(curr, up);
            }
            if (row < n - 1) {
                int down =  (row + 1) * m + col;
                union(curr, down);
            }
            if (col > 0) {
                int left = row * m + (col - 1);
                union(curr, left);
            }
            if (col < m - 1) {
                int right = row * m + (col + 1);
                union(curr, right);
            }
        }

        void union(int a, int b) {
            if (root[a] < 0 || root[b] < 0) return;
            int aParrent = find(a);
            int bParrent = find(b);
            if (aParrent != bParrent) {
                root[aParrent] = bParrent;
                groups--;
            }
        }

        int find(int a) {
            if (root[a] == a) return a;
            return root[a] = find(root[a]);
        }
    }

    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        UnionFind uf = new UnionFind(n, m);
        List<Integer> answer = new ArrayList<>();
        for (int[] position : positions) {
            uf.addGroup(position[0], position[1]);
            answer.add(uf.groups);
        }
        return answer;
    }
}
