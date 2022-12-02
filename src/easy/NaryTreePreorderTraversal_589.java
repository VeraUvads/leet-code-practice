package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreePreorderTraversal_589 {
    class Node {
        public int val;
        public List<Node> children;
    }
    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/?envType=study-plan&id=level-1

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<Node> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            list.add(current.val);
            if (current.children != null) {
                for (int i = current.children.size() - 1; i >= 0; i-- ) {
                    queue.addFirst(current.children.get(i));
                }
            }
        }
        return list;
    }
}
