package medium;


import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_II_117 {
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150

    public Node connectBFS(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            while (size != 0) {
                Node curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                prev = curr;
                size--;
            }
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Node leftMost = root;
        Node prev = leftMost;
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                curr.left.next = curr.right;
            }
            if (leftMost == curr || leftMost == null) {
                leftMost = curr.left == null ? curr.right : curr.left;
                prev = leftMost;
            } else {
                while (prev.next != null) prev = prev.next;
                prev.next = curr.left == null ? curr.right : curr.left;
            }

            curr = curr.next == null ? leftMost : curr.next;
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
