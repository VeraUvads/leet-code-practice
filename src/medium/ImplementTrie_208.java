package medium;


public class ImplementTrie_208 {

    class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node local = root;
            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);
                Node child = local.containsKey(symbol);
                if (child == null) {
                    child = new Node(symbol);
                    local.put(child);
                }
                local = child;
            }
            local.setTransition(true);
        }

        public boolean search(String word) {
            Node node = searchPrefix(word);
            return node != null && node.isTransition();
        }

        private Node searchPrefix(String word) {
            Node local = root;
            for (int i = 0; i < word.length(); i++) {
                char symbol = word.charAt(i);
                Node child = local.containsKey(symbol);
                if (child == null) return null;
                local = child;
            }
            return local;
        }

        public boolean startsWith(String prefix) {
            Node node = searchPrefix(prefix);
            return node != null;
        }

        private class Node {
            private final Node[] childs;
            private char symbol;
            private boolean isTransition = false;

            private Node() {
                this.childs = new Node[26];
            }

            private Node(char symbol) {
                this.symbol = symbol;
                this.childs = new Node[26];
            }

            private Node(char symbol, Node[] childs) {
                this.symbol = symbol;
                this.childs = childs;
            }

            public Node containsKey(char letter) {
                return childs[letter - 'a'];
            }

            public void put(Node node) {
                childs[node.symbol - 'a'] = node;
            }

            public void setTransition(boolean isTransition) {
                this.isTransition = isTransition;
            }

            public boolean isTransition() {
                return isTransition;
            }

        }
    }

}
