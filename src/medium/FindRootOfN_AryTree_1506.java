package medium;


import java.util.ArrayList;
import java.util.List;

public class FindRootOfN_AryTree_1506 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // https://leetcode.com/problems/find-root-of-n-ary-tree/description/
    public Node findRoot(List<Node> tree) {
        int sum = 0;
        for (Node node : tree) {
            sum += node.val;
            for (Node child : node.children) {
                sum -= child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == sum) return node;
        }
        return null;
    }
}
