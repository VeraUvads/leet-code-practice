package medium;

public class AddTwoNumbers_2 {
    // https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode();
        ListNode temp = result;
        int inMemory = 0;
        while (l1 != null || l2 != null || inMemory != 0) {
            int sum = inMemory;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            inMemory = sum / 10;
            sum %= 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node6 = new ListNode(4);
        ListNode node5 = new ListNode(6, node6);

        ListNode node4 = new ListNode(5, node5);

        ListNode result = addTwoNumbers(node1, node4);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

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
}
