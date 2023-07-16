package medium;

import utils.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList_426 {
    // https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/editorial/

    class SolutionRecursive {
        private Node first = null;
        private Node last = null;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            helper(root);
            first.left = last;
            last.right = first;
            return first;
        }

        private void helper(Node root) {
            if (root == null) return;
            helper(root.left);
            if (last == null) {
                first = root;
            } else {
                last.right = root;
                root.left = last;
            }
            last = root;
            helper(root.right);
        }

    }
}
