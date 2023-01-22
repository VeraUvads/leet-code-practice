package easy;

import utils.ListNode;


public class RemoveDuplicatesFromSortedList_83 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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

