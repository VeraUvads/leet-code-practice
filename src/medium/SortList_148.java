package medium;

public class SortList_148 {
    // https://leetcode.com/problems/sort-list/description/?envType=study-plan&id=level-2
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode secondHalf = sortList(middle.next);
        middle.next = null;
        ListNode firstHalf = sortList(head);
        return merge(firstHalf, secondHalf);
    }

    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                head.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                head.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            head = head.next;
        }
        if (firstHalf != null) {
            head.next = firstHalf;
        }
        if (secondHalf != null) {
            head.next = secondHalf;
        }
        return dummy.next;
    }


    private ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
