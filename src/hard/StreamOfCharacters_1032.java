package hard;

public class StreamOfCharacters_1032 {
    // https://leetcode.com/problems/stream-of-characters/description/
    class StreamChecker {
        TrieNode wordsRoot = new TrieNode();
        StringBuilder builder = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words) {
                TrieNode curr = wordsRoot;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char letter = word.charAt(i);
                    TrieNode node = curr.getChild(letter);
                    if (node == null) {
                        node = curr.addChild(letter);
                    }
                    curr = node;
                }
                curr.isWord = true;
            }
        }

        public boolean query(char letter) {
            builder.append(letter);
            return compare();
        }

        private boolean compare() {
            TrieNode curr = wordsRoot;
            for (int i = builder.length() - 1; i >= 0; i--) {
                char symbol = builder.charAt(i);
                TrieNode node = curr.getChild(symbol);
                if (node == null) return false;
                if (node.isWord) return true;
                curr = node;
            }
            return curr.isWord;
        }

        class TrieNode {
            char letter;
            TrieNode[] children;
            boolean isWord = false;

            public TrieNode() {
                this.children = new TrieNode[26];
            }

            public TrieNode(char letter) {
                this.letter = letter;
                this.children = new TrieNode[26];
            }

            public TrieNode getChild(char letter) {
                return children[letter - 'a'];
            }

            public TrieNode addChild(char letter) {
                TrieNode node = new TrieNode(letter);
                children[letter - 'a'] = node;
                return node;
            }
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
}
