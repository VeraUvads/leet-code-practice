package easy

class PalindromeLinkedList_234 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private var frontPointer: ListNode? = null;
    fun isPalindrome(head: ListNode?): Boolean {
        frontPointer = head
        return reqursion(head)
    }

    private fun reqursion(head: ListNode?): Boolean {
        if (head == null) return true
        if (!reqursion(head.next)) return false
        if (frontPointer?.`val` != head.`val`) return false
        frontPointer = frontPointer?.next;
        return true
    }


    fun isPalindromeWithReverse(head: ListNode?): Boolean {
        if (head == null ) return true
        val middle = findMiddle(head)
        var reverseHead = reverse(middle.next)
        var head2 : ListNode? = head;
        while (reverseHead != null) {
            if (head2?.`val`  != reverseHead.`val`) return false;
            head2 = head2.next
            reverseHead = reverseHead.next
        }

        return true;
    }

    private fun findMiddle(head: ListNode) : ListNode {
        var slow = head;
        var fast : ListNode? = head;
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow.next!!
            fast = fast.next?.next
        }
        return slow
    }

    private fun reverse(head: ListNode?) : ListNode? {
        var previous : ListNode? = null;
        var newHead = head;
        while (newHead != null) {
            val temp = newHead.next
            newHead.next = previous
            previous = newHead
            newHead = temp
        }
        return previous
    }

}