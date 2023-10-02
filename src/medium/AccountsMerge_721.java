package medium;

import java.util.*;

public class AccountsMerge_721 {
    // https://leetcode.com/problems/accounts-merge/description/?envType=study-plan&id=level-3

    // N is the number of vertices in the graph. α(alpha) refers to the Inverse Ackermann function.
    // In practice, we assume it's a constant. In other words, O(α(N)) is regarded as O(1) on average.
    static class UnionFind {
        int[] parent;
        int[] rank;
        int groupCount;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            groupCount = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) { // O(α(N))
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]); // path compression
        }

        public void union(int x, int y) { // O(α(N))
            int xParent = find(x);
            int yParent = find(y);
            if (xParent == yParent) return;
            groupCount--;
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
        }

    }

    class Solution {
        private Map<String, Integer> adjacent = new HashMap<>();
        private UnionFind unionFind;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            unionFind = new UnionFind(accounts.size());
            for (int index = 0; index < accounts.size(); index++) { // O(N)
                List<String> account = accounts.get(index);
                for (int i = 1; i < account.size(); i++) { // O(K)
                    String email = account.get(i);
                    if (adjacent.containsKey(email)) {
                        unionFind.union(adjacent.get(email), index); // O(a(N))
                    } else {
                        adjacent.put(email, index);
                    }
                }
            } // O (NKa(N))
            Map<Integer, List<String>> components = new HashMap<>();
            for (String email : adjacent.keySet()) { // O(NK)
                int value = adjacent.get(email);
                int groupId = unionFind.find(value); // O(a(N))
                List<String> emails = components.getOrDefault(groupId, new ArrayList<>());
                emails.add(email);
                components.put(groupId, emails);
            } // 2 * O(NKa(N)) == O(NKa(N))
            List<List<String>> answer = new ArrayList<>();
            for (int groupId : components.keySet()) {
                List<String> emails = components.get(groupId);
                Collections.sort(emails);
                emails.add(0, accounts.get(groupId).get(0));
                answer.add(emails);
            } //   O(NK * log(NK)) - нужно отсортировать все элементы, все элементы это NK
            return answer; // O(NKa(N)) + O(NK * log(NK))
        }

    }
}
