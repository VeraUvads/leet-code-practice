package medium;

import utils.TreeNode;

import java.util.HashMap;

public class BinaryTreeColoringGame_1145 {
    //https://leetcode.com/problems/binary-tree-coloring-game/submissions/1067615901/
    HashMap<Integer, TreeNode> parents = new HashMap<>();

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        fillParents(root, null);
        TreeNode enemy = getEnemy(root, x);
        int fromParent = dfs(parents.get(enemy.val), enemy);
        int fromLeft = dfs(enemy.left, enemy);
        int fromRight = dfs(enemy.right, enemy);
        int comb1 = fromParent + fromLeft + 1;
        if (fromRight > comb1) return true;

        int comb2 = fromParent + fromRight + 1;
        if (fromLeft > comb2) return true;

        int comb3 = fromLeft + fromRight + 1;
        return fromParent > comb3;
    }

    void fillParents(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parents.put(node.val, parent);
        fillParents(node.left, node);
        fillParents(node.right, node);
    }

    private TreeNode getEnemy(TreeNode root, int x) {
        if (x == root.val) return root;
        TreeNode parent = parents.get(x);
        if (parent.left != null  && parent.left.val == x) return parent.left;
        return parent.right;
    }

    int dfs(TreeNode node, TreeNode prev) {
        if (node == null) return 0;
        // System.out.println(node.val);
        int left = 0;
        if (node.left != null && node.left != prev) {
            left = dfs(node.left, node);
        }
        int right = 0;
        if (node.right != null && node.right != prev) {
            right = dfs(node.right, node);
        }
        int parent = 0;
        if (parents.get(node.val) != null && parents.get(node.val) != prev) {
            parent = dfs(parents.get(node.val), node);
        }
        return left + right + 1 + parent;
    }
}
