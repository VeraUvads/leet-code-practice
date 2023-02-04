package hard;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    // https://leetcode.com/problems/merge-k-sorted-lists/description/

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    public ListNode mergeKListsBF(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (true) {
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) continue;
                if (minNode == null || minNode.val > node.val) {
                    minNode = node;
                    minIndex = i;
                }
            }
            if (minNode == null) break;
            dummy.next = lists[minIndex];
            dummy = dummy.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return head.next;
    }

}
