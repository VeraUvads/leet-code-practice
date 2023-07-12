package medium;

import utils.ListNode;

import java.util.Stack;

public class ReverseLinkedList_II_92 { // need to resolve
    // https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode first = dummy;
            int counter = 1;
            while (counter != left) {
                first = first.next;
                counter++;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode last = first.next;
            while (counter != right + 1) {
                stack.add(last);
                last = last.next;
                counter++;
            }
            while (!stack.isEmpty()) {
                first.next = stack.pop();
                first = first.next;
            }
            first.next = last;
            return dummy.next;
        }
    }
}
