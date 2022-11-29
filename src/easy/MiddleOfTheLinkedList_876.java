package easy;

public class MiddleOfTheLinkedList_876 {
    public class ListNode {
        int val;
        ListNode next;
    }
    // https://leetcode.com/problems/middle-of-the-linked-list/description/

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
