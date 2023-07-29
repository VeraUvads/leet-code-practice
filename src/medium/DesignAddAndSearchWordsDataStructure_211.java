package medium;

public class DesignAddAndSearchWordsDataStructure_211 {
    // https://leetcode.com/problems/design-add-and-search-words-data-structure/
    class WordDictionary {
        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                Node next = curr.getChild(letter);
                if (next == null) next = curr.addChild(letter);
                curr = next;
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, Node node) {
            if (node == null) return false;
            char letter = word.charAt(index);
            if (index == word.length() - 1) {
                if (letter == '.') {
                    for (Node child : node.children) {
                        if (child != null  && child.isWord) return true;
                    }
                    return false;
                }
                if (node.getChild(letter) != null && node.getChild(letter).isWord) return true;
                return false;
            }
            if (letter == '.') {
                for (Node child : node.children) {
                    if (dfs(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            }
            return dfs(word, index + 1, node.getChild(letter));
        }

        private class Node {
            char letter;
            Node[] children;
            boolean isWord;

            Node() {
                this.children = new Node[26];
                this.isWord = false;
            }

            Node(char letter) {
                this.letter = letter;
                this.children = new Node[26];
                this.isWord = false;
            }

            Node addChild(char child) {
                children[child - 'a']  = new Node(child);
                return children[child - 'a'];
            }

            Node getChild(char child) {
                return children[child - 'a'];
            }
        }
    }
}
