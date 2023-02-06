package medium.not_finshed;

import utils.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {
    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

    // Second Approach
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> seen = new HashSet<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);

        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == k) {
                    List<Integer> answer = new ArrayList<>();
                    for (TreeNode n : queue)
                        answer.add(n.val);
                    return answer;
                }
                dist++;
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }

            seen.add(node);

            if (node.left != null && !seen.contains(node.left)) {
                queue.add(node.left);
            }
            if (node.right != null && !seen.contains(node.right)) {
                queue.add(node.right);
            }
            TreeNode par = parent.getOrDefault(node, null);
            if (par != null && !seen.contains(par)) {
                queue.add(par);
            }
        }
        return new ArrayList<>();
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        this.parent.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
