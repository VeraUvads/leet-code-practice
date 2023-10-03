package hard;

public class SimilarStringGroups_839 {
    // https://leetcode.com/problems/similar-string-groups/description/

    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (uf.isConnected(i, j)) continue;
                boolean isSimilar = isSimilar(strs[i], strs[j]);
                if (isSimilar) uf.union(i, j);
            }
        }
        return uf.groups;
    }

    private boolean isSimilar(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            char symbol1 = str1.charAt(i);
            char symbol2 = str2.charAt(i);
            if (symbol1 != symbol2) diff++;
            if (diff > 2) return false;
        }
        return diff == 0 || diff == 2;
    }

    class UnionFind {
        int groups;
        int[] root;

        public UnionFind(int n) {
            groups = n;
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        boolean isConnected(int x, int y) {
            int xParrent = find(x);
            int yParrent = find(y);
            return xParrent == yParrent;
        }

        int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int xParrent = find(x);
            int yParrent = find(y);
            if (xParrent == yParrent) return;
            root[xParrent] = yParrent;
            groups--;
        }
    }
}
