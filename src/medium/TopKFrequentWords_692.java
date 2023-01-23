package medium;

import java.util.*;

public class TopKFrequentWords_692 {
    // https://leetcode.com/problems/top-k-frequent-words/description/

    // O (N) - The longest, but fastest
    class Solution {
        private List<String> answer;
        private int k;

        public List<String> topKFrequent(String[] words, int k) {
            this.k = k;
            this.answer = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for (String word : words) {
                int freq = map.getOrDefault(word, 0) + 1;
                map.put(word, freq);
                maxFreq = Math.max(freq, maxFreq);
            }
            TreeNode[] bucket = new TreeNode[maxFreq + 1];
            for (String word : map.keySet()) {
                int freq = map.get(word);
                if (bucket[freq] == null) {
                    bucket[freq] = new TreeNode();
                }
                addWord(bucket[freq], word);
            }

            for (int i = maxFreq; i > 0; i--) {
                if (answer.size() == k) break;
                getWords(bucket[i], new StringBuilder());
            }
            return answer;
        }

        public void getWords(TreeNode root, StringBuilder builder) {
            if (root == null || k == 0) return;
            if (root.isWord) {
                answer.add(builder.toString());
                k--;
            }
            for (int i = 0; i < root.childs.length; i++) {
                TreeNode node = root.childs[i];
                if (node != null) {
                    builder.append(node.letter);
                    getWords(node, builder);
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }

        public void addWord(TreeNode root, String word) {
            int index = 0;
            while (index < word.length()) {
                char letter = word.charAt(index);
                TreeNode node = root.getChild(letter);
                if (node == null) {
                    node = root.addChild(letter);
                }
                root = node;
                index++;
            }
            root.isWord = true;
        }


        public class TreeNode {
            char letter;
            TreeNode[] childs;
            boolean isWord = false;

            public TreeNode() {
                childs = new TreeNode[26];
            }

            public TreeNode(char letter) {
                this.letter = letter;
                childs = new TreeNode[26];
            }

            public TreeNode getChild(char child) {
                return childs[child - 'a'];
            }

            public TreeNode addChild(char child) {
                TreeNode node = new TreeNode(child);
                childs[child - 'a'] = node;
                return node;
            }

        }
    }

    class Solution2 {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            List<String> answer = new ArrayList<>(map.keySet());

            Collections.sort(
                    answer,
                    (w1, w2) -> map.get(w2) == map.get(w1) ? w1.compareTo(w2) : map.get(w2) - map.get(w1)
            );
            return answer.subList(0, k);
        }
    }

    class Solution3 {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            List<String> answer = new ArrayList<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<String> queue = new PriorityQueue<>(
                    (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                            w2.compareTo(w1) : map.get(w1) - map.get(w2)
            );
            for (String word : map.keySet()) {
                queue.add(word);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            while (!queue.isEmpty()) {
                answer.add(queue.poll());
            }
            Collections.reverse(answer);
            return answer;
        }
    }
}
