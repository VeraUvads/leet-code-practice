package easy;

import java.util.Stack;

public class RemoveDuplicatesFromSortedList_83 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

    public static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

