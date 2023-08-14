package medium;

import utils.ListNode;

public class InsertionSortList_147 {
    // https://leetcode.com/explore/learn/card/sorting/694/comparison-based-sorts/4485/

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            ListNode next = prev.next;
            prev.next = curr;
            ListNode temp = curr.next;
            curr.next = next;
            curr = temp;
        }

        return dummy.next;
    }
}
