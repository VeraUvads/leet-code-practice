package medium;

import utils.ListNode;

import java.util.Stack;

public class ReorderList_143 {
    // https://leetcode.com/problems/reorder-list/description/

    class Solution { // Reverse the Second Part of the List and Merge Two  Lists
        public void reorderList(ListNode head) {
            Stack<ListNode> stack = new Stack();
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondList = slow.next;
            slow.next = null;
            ListNode temp = secondList;
            secondList = reverseList(secondList);
            temp = secondList;
            while (temp != null) {
                temp = temp.next;
            }
            mergeTwoList(head, secondList);
        }

        private void mergeTwoList(ListNode start, ListNode second) {
            ListNode dummy = new ListNode();
            while (start != null && second != null) {
                ListNode nextStart = start.next;
                ListNode secondStart = second.next;
                dummy.next = start;
                dummy.next.next = second;
                second.next = null;
                start = nextStart;
                second = secondStart;
                dummy = dummy.next.next;
            }
            if (second != null) {
                dummy.next = second;
            }
            if (start != null) {
                dummy.next = start;
            }
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }


    }

    public void reorderListStack(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = null;
            stack.add(slow);
            slow = next;
        }
        while (!stack.isEmpty() && head != null) {
            ListNode next = head.next;
            head.next = stack.pop();
            head.next.next = next;
            head = next;
        }
    }
}
