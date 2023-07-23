package medium;

import utils.ListNode;

public class RemoveDuplicatesFromSortedList_II_82 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        ListNode holder = dummy;
        dummy.next = head;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode next = dummy.next;
            if (next.val == next.next.val) {
                while (next.next != null && next.next.val == next.val) {
                    next.next = next.next.next;
                }
                dummy.next = next.next;
            } else {
                dummy = dummy.next;
            }
        }

        return holder.next;
    }
}
