package easy;

import utils.ListNode;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode previous = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }
}
