package easy;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists_160 {
    // https://leetcode.com/problems/intersection-of-two-linked-lists/description/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
