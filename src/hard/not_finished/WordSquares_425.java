package hard.not_finished;

import java.util.ArrayList;
import java.util.List;

public class WordSquares_425 {
    // https://leetcode.com/problems/word-squares/description/


    Node root;
    List<List<String>> answer;

    public List<List<String>> wordSquares(String[] words) {
        this.root = new Node();
        this.answer = new ArrayList<>();
        for (String word : words) {
            buildTrie(word);
        }
        for (String word : words) {
            List<String> list = new ArrayList<>();
            list.add(word);
            if (!startFromWord(word)) {
                answer.remove(answer.size() - 1);
            }
        }
        throw new RuntimeException("");
    }

    private boolean startFromWord(String word) {
        for (int i = 1; i < word.length(); i++) {
            char letter = word.charAt(i);
            boolean found = search(word.length(), root.findChild(letter));
            if (!found) return false;
        }
        throw new RuntimeException("");
    }

    private boolean search(int wordLength, Node node) {
        if (node == null) return false;
        throw new RuntimeException("");
//        search()
    }


    private void buildTrie(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Node curr = node.findChild(letter);
            if (curr == null) {
                curr = node.addChild(letter);
            }
            curr.counter++;
            node = curr;
        }
        node.isEnd = true;
    }


    class Node {
        char letter;
        Node[] children;
        int counter;
        boolean isEnd;

        public Node() {
            this.children = new Node[26];
            this.counter = 0;
            this.isEnd = false;
        }

        public Node(char letter) {
            this.letter = letter;
            this.children = new Node[26];
            this.counter = 0;
            this.isEnd = false;
        }

        Node findChild(char letter) {
            return children[letter - 'a'];
        }

        Node addChild(char letter) {
            return children[letter - 'a'] = new Node(letter);
        }

    }

}
