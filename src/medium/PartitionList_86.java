package medium;

import utils.ListNode;

public class PartitionList_86 {
    // https://leetcode.com/problems/partition-list/description/
    public ListNode partition(ListNode head, int x) {
        ListNode afterX = new ListNode();
        ListNode beforeX = new ListNode();
        ListNode afterStart = afterX;
        ListNode beforeStart = beforeX;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                afterX.next = curr;
                afterX = afterX.next;
            } else {
                beforeX.next = curr;
                beforeX = beforeX.next;
            }
            curr = curr.next;
        }
        beforeX.next = null;
        afterX.next = beforeStart.next;

        return afterStart.next;
    }
}
