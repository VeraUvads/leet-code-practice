package medium;

import utils.ListNode;

public class SwapNodesInPairs_24 {
    // https://leetcode.com/problems/swap-nodes-in-pairs/description/
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode second = head.next;
        if (second == null) return head;
        ListNode temp = second.next;
        second.next = head;
        head.next = swapPairs(temp);
        return second;
    }
}
