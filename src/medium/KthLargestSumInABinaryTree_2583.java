package medium;

import utils.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestSumInABinaryTree_2583 {
    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        PriorityQueue<Long> sums = new PriorityQueue<>(Comparator.comparingLong(a -> -a));
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            while (size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            sums.add(sum);
        }
        if (k > sums.size()) return -1;
        long answer = 0;
        while (k != 0) {
            answer = sums.poll();
            k--;
        }
        return answer;
    }
}
