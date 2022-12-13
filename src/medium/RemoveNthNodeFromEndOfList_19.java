package medium;

public class RemoveNthNodeFromEndOfList_19 {
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        head = dummy;
        length -= n;
        while (length > 0) {
            head = head.next;
            length--;
        }
        head.next = head.next.next;
        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nodeBeforeRemove = dummy;
        ListNode currentNode = dummy;
        while (n != 0) {
            currentNode = currentNode.next;
            n--;
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            nodeBeforeRemove = nodeBeforeRemove.next;
        }
        nodeBeforeRemove.next = nodeBeforeRemove.next.next;
        return dummy.next;
    }
}
