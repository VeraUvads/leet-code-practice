package medium;

public class DesignLinkedList_707 {
    static class MyLinkedList {

        private Node head;
        private Node tail;
        private int size;

        public  MyLinkedList() {
            head = new Node();
            tail = head;
            size = 0;
        }

        public int get(int index) {
            Node node = getNode(index);
            if (node == null) return -1;
            return node.val;
        }

        private Node getNode(int index) {
            if (index >= size) return null;
            Node node = head;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node;
        }

        public void addAtHead(int val) {
            addNext(head, val);
            if (tail == head) {
                tail = head.next;
            }
            size++;
        }

        public void addAtTail(int val) {
            tail.next = new Node(val);
            tail = tail.next;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
            } else if (index < size) {
                Node node = getNode(index - 1);
                addNext(node, val);
                size++;
            }
        }

        private void addNext(Node node, int val) {
            Node temp = node.next;
            node.next = new Node(val);
            node.next.next = temp;
        }

        public void deleteAtIndex(int index) {
            Node node = getNode(index - 1);
            if (node == null) return;
            Node deleting = node.next;

            if (deleting == tail) {
                tail = node;
                tail.next = null;
            } else if (deleting != null) {
                node.next = deleting.next;
                deleting.next = null;
                size--;
            }
        }

        private class Node {
            int val;
            Node next;

            private Node() {}

            private Node(int val) {
                this.val = val;
                this.next = null;
            }

            private Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);    // linked list becomes 1->2->3
        obj.get(1);              // return 2
        obj.deleteAtIndex(1);    // now the linked list is 1->3
        obj.get(1);
    }
}
