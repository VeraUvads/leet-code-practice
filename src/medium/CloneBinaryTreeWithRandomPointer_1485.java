package medium;

import utils.Node;

import java.util.HashMap;

public class CloneBinaryTreeWithRandomPointer_1485 {
    // https://leetcode.com/problems/clone-binary-tree-with-random-pointer/description/
    public class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);
        Node node = new Node(root.val);
        map.put(root, node);
        node.left = copyRandomBinaryTree(root.left);
        node.right = copyRandomBinaryTree(root.right);
        node.random = copyRandomBinaryTree(root.random);
        return node;
    }
}
