package hard;

import java.util.ArrayList;
import java.util.List;

public class WordSquares_425 {
    // https://leetcode.com/problems/word-squares/description/
 /*
   b/w a l l
    a  r e a
    l  e a d
    l  a d y


    "area","lead","wall","lady","ball"

    a - r - e - a
    l - e - a - d
      - a - d - y
    w - a - l - l
    b - a - l - l



    */

    Node root;
    List<List<String>> answer;
    String[] words;
    int length;

    public List<List<String>> wordSquares(String[] words) {
        this.root = new Node();
        this.answer = new ArrayList<>();
        this.words = words;
        this.length = words[0].length();
        for (int i = 0; i < words.length; i++) {
            buildTrie(i);
        }
        List<String> list = new ArrayList<>();
        for (String word : words) { // N
            list.add(word);
            backTracking(list, 1);
            list.remove(list.size() - 1);
        }
        return answer;
    }// aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa

    private void backTracking(List<String> current, int index) {
        if (index == length) {
            answer.add(new ArrayList<>(current));
            return;
        }
        Node node = root;
        for (String string : current) { // L
            node = node.findChild(string.charAt(index));
            if (node == null) return;
        }
        for (Integer wordIndex : node.wordsList) { // N
            current.add(words[wordIndex]);
            backTracking(current, index + 1); // L
            current.remove(current.size() - 1);
        }
    }

    private void buildTrie(int index) {
        String word = words[index];
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Node curr = node.findChild(letter);
            if (curr == null) {
                curr = node.addChild(letter);
            }
            curr.counter++;
            node = curr;
            node.wordsList.add(index);
        }
    }


    class Node {
        char letter;
        Node[] children;
        int counter;
        List<Integer> wordsList = new ArrayList();

        public Node () {
            this.children = new Node[26];
            this.counter = 0;
        }

        public Node (char letter) {
            this.letter = letter;
            this.children = new Node[26];
            this.counter = 0;
        }

        Node findChild (char letter) {
            return children[letter - 'a'];
        }

        Node addChild (char letter) {
            return children[letter - 'a'] = new Node(letter);
        }

    }

}
