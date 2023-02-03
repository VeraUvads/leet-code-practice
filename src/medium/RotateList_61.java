package medium;

import utils.ListNode;

public class RotateList_61 {
    // https://leetcode.com/problems/rotate-list/description/

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1;
        ListNode last = head;
        while (last.next != null) {
            size++;
            last = last.next;
        }
        last.next = head;
        k %= size;
        ListNode dummy = head;
        for (int i = 0; i < size - k - 1; i++) {
            dummy = dummy.next;
        }
        ListNode newHead = dummy.next;
        dummy.next = null;
        return newHead;
    }
}
