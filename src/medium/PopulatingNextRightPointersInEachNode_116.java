package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

    // Space O(1)
    // Main ideas:
    // 1) node.left.next = node.right;
    // 2) node.right.next = node.next.left;
    public Node connect(Node root) {
        if (root == null) return null;
        Node leftMost = root;
        while (leftMost != null) {
            Node head = leftMost;
            while (head != null && head.left != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // Interesting way to cut nodes in Tree by level
    public Node connectBfs(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    // using null
    public Node connectWithNull(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                if (queue.size() != 0) queue.add(null);
                continue;
            }
            curr.next = queue.peek();
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
