package easy;
//  https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists_21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // iterative
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode root = new ListNode(0);
        ListNode iterator = root;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                iterator.next = list2;
                list2 = list2.next;
            } else {
                iterator.next = list1;
                list1 = list1.next;
            }
            iterator = iterator.next;
        }
        if (list1 == null && list2 != null) {
            iterator.next = list2;
        } else if (list2 == null && list1 != null) {
            iterator.next = list1;
        }
        return root.next;
    }

    // recursive
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
