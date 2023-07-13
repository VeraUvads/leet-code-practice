package medium;

import utils.ListNode;

import java.util.Stack;

public class ReverseLinkedList_II_92 {
    // https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
    class SolutionIterative {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) return null;
            ListNode curr = head, prev = null; // curr == 2, prev == 1 ?
            while (left > 1) {
                prev = curr;
                curr = curr.next;
                left--;
                right--;
            }
            ListNode startForReversed = prev, startForThirdPart = curr;
            ListNode lastReversed = null;
            while (right > 0) {
                lastReversed = curr.next;
                curr.next = prev;
                prev = curr;
                curr = lastReversed;
                right--;
            }
            if (startForReversed != null) {
                startForReversed.next = prev;
            } else {
                head = prev;
            }
            startForThirdPart.next = curr;
            return head;
        }
    }
    class Solution {// need to resolve
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
