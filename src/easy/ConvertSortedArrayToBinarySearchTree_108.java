package easy;

import utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan&id=level-2

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int start = 0;
        int end = nums.length - 1;
        return start(nums, start, end);
    }


    private TreeNode start(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = start(nums, start, mid - 1);
        node.right = start(nums, mid + 1, end);
        return node;
    }

}
