package hard;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
    // https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/

    HashMap<Integer, ArrayList<NodeData>> twoMaxNodeOnLevel = new HashMap<>();
    HashMap<Integer, NodeData> nodeMap = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] answer = new int[queries.length];
        if (root == null) return answer;
        dfs(root, 0);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            NodeData data = nodeMap.get(query);
            int onLevel = data.level;
            ArrayList<NodeData> neighbours = twoMaxNodeOnLevel.get(onLevel);
            answer[i] = onLevel - 1;

            if (neighbours.size() > 1) {
                NodeData first = neighbours.get(0);
                NodeData second = neighbours.get(1);
                if (first !=  data && second != data) {
                    answer[i]+= Math.max(first.depth, second.depth);
                } else if (first == data) {
                    answer[i] += second.depth;
                } else {
                    answer[i] += first.depth;
                }
            }
        }
        return answer;
    }

    private int dfs(TreeNode root, int currentLength) {
        if (root == null) return 0;
        int leftDepth = dfs(root.left, currentLength + 1);
        int rightDepth = dfs(root.right, currentLength + 1);
        int depthForNode =  Math.max(leftDepth, rightDepth) + 1;
        NodeData data = new NodeData(root, depthForNode, currentLength);
        ArrayList<NodeData> list = twoMaxNodeOnLevel.getOrDefault(currentLength, new ArrayList<>());
        list.add(data);
        if (list.size() > 2) {
            int min = 0;
            for (int i = 0 ; i < list.size(); i++) {
                if (list.get(i).depth <= list.get(min).depth) {
                    min = i;
                }
            }
            list.remove(min);
        }
        twoMaxNodeOnLevel.put(currentLength, list);
        nodeMap.put(root.val, data);
        return depthForNode;
    }

    class NodeData {
        TreeNode node;
        int depth;
        int level;
        public NodeData(TreeNode node, int depth, int level) {
            this.node = node;
            this.depth = depth;
            this.level = level;
        }
    }

}
