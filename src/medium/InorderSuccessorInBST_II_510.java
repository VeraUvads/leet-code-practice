package medium;

import utils.Node;

public class InorderSuccessorInBST_II_510 {
    // https://leetcode.com/problems/inorder-successor-in-bst-ii/description/


    //       8
    //   4        10
    // 2   6    9   11
    //    5  7
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            Node leftMost = node.right;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
            }
            return leftMost;
        }
        Node child = node;
        Node parent = child.parent;
        while (parent != null && child == parent.right) {
            child = parent;
            parent = child.parent;
        }
        return parent;
    }
    //       15
    //   6            18
    // 3     7      17    20
    //2 4   n  13  n  n  n   n
}
