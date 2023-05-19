package medium;

import java.util.List;

public class WordBreak_139 {
    // https://leetcode.com/problems/word-break/description/

    String string;
    Node root;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.string = s;
        int n = s.length();
        this.dp = new boolean[n + 1];
        dp[0] = true;
        root = trie(wordDict);
        for (int i = 0; i < n; i++) { // N^2 * K
            if (!dp[i]) continue;
            for (int j = i; j < n; j++) {
                dp[j + 1] = dp[j + 1] || search(i, j);
            }
        }
        return dp[dp.length - 1];
    }

    private boolean search(int start, int end) {  // O(k)
        Node parent = root;
        for (int i = start; i <= end; i++) {
            Node child = parent.getChild(string.charAt(i));
            if (child == null) return false;
            parent = child;
        }
        return parent.isWord;
    }

    private Node trie(List<String> wordDict) { // O(k*m)  k - average length of word
        Node root = new Node();
        for (String word : wordDict) { // O(m)
            Node current = root;
            for (int i = 0; i < word.length(); i++) { // O (k)
                char letter = word.charAt(i);
                Node child = current.getChild(letter);
                if (child == null) {
                    child = current.addChild(letter);
                }
                current = child;
            }
            current.isWord = true;
        }
        return root;
    }

    class Node {
        char letter;
        Node[] children = new Node[26];
        boolean isWord = false;

        public Node() { }

        public Node(char letter) {
            this.letter = letter;
        }

        Node getChild(char letter) {
            return children[letter - 'a'];
        }

        Node addChild(char letter) {
            Node child = new Node(letter);
            children[letter - 'a'] = child;
            return child;
        }
    }
}
