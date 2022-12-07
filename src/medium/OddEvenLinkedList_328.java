package medium;

public class OddEvenLinkedList_328 {
    // https://leetcode.com/problems/odd-even-linked-list/description/

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int index = 1;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
