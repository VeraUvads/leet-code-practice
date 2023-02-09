package hard;

import utils.ListNode;

public class ReverseNodesInKGroup_25 {
    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/

    public ListNode reverseKGGroupRecursive(ListNode head, int k) {
        if (head == null) return null;
        ListNode lastAtTime = head;
        int count = 0;
        while (lastAtTime != null && count < k) {
            lastAtTime = lastAtTime.next;
            count++;
        }
        if (count == k) {
            ListNode newHead = reverse(head, k);
            head.next = reverseKGroup(lastAtTime, k);
            return newHead;
        }

        return head;
    }


    private ListNode reverse(ListNode head, int k) {
        if (head == null) return null;
        ListNode previous = null;
        ListNode current = head;
        while (k > 0) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            k--;
        }
        return previous;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        ListNode dummyHolder = dummy;
        ListNode lastAtTime = head;
        while (lastAtTime != null) {
            int count = 0;
            ListNode temp = lastAtTime;
            while (lastAtTime != null && count < k) {
                lastAtTime = lastAtTime.next;
                count++;
            }
            if (count == k) {
                dummy.next = reverse(head, k);
                head = lastAtTime;
                while (dummy.next != null) {
                    dummy = dummy.next;
                }
            } else {
                dummy.next = temp;
            }
        }
        return dummyHolder.next;
    }


}
