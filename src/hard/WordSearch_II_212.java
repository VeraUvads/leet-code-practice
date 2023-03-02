package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch_II_212 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    List<String> list;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.list = new ArrayList<>();
        Node root = trie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(i, j, root, new StringBuilder());
            }
        }
        return list;
    }

    private void backtracking(int row, int col, Node node, StringBuilder builder) {
        if (node.wordsEnd != 0) {
            list.add(builder.toString());
            node.wordsEnd--;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) return;
        char cur = board[row][col];
        if (cur == '0') return;
        Node child = node.getChild(cur);
        if (child == null) return;
        builder.append(cur);
        board[row][col] = '0';
        for (int[] dir : dirs) {
            backtracking(row + dir[0], col + dir[1], child, builder);
        }
        builder.deleteCharAt(builder.length() - 1);
        board[row][col] = cur;
        if (child.children.isEmpty()) {
            node.children.remove(child.value);
        }
    }

    private Node trie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                Node node = cur.getChild(letter);
                if (node == null) {
                    node = new Node(word.charAt(i));
                    cur.addChild(node);
                }
                cur = node;
            }
            cur.wordsEnd++;
        }
        return root;
    }

    class Node {
        char value;
        HashMap<Character, Node> children;
        int wordsEnd = 0;

        public Node() {
            this.children = new HashMap<>();
        }

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        public Node getChild(char letter) {
            return children.getOrDefault(letter, null);
        }

        public Node addChild(Node node) {
            return children.put(node.value, node);
        }

    }
}
