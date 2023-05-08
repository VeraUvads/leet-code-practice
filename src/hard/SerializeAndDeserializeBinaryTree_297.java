package hard;

import utils.TreeNode;

public class SerializeAndDeserializeBinaryTree_297 {
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null ");
            return;
        }
        builder.append(root.val);
        builder.append(" ");
        dfs(root.left, builder);
        dfs(root.right, builder);
    }

    // Decodes your encoded data to tree.
    // 1 2 null null 3 4 null null 5 null null
    private int position;
    private String[] arr;
    public TreeNode deserialize(String data) {
        arr = data.split(" ");
        position = 0;
        return build();
    }

    private TreeNode build() {
        TreeNode head = parse(arr[position++]);
        if (head == null) return null;
        head.left = build();
        head.right = build();
        return head;
    }

    private TreeNode parse(String string) {
        if (string.equals("null")) return null;
        return new TreeNode(Integer.parseInt(string));
    }
}
