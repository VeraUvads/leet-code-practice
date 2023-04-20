package medium;

import utils.ListNode;

public class DeleteNodeInALinkedList_237 {
    //https://leetcode.com/problems/delete-node-in-a-linked-list/

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
