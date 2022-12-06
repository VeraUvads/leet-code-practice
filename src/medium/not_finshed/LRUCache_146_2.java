package medium.not_finshed;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146_2 extends LinkedHashMap<Integer, Integer> {

    // NOT FINISHED
    // https://leetcode.com/problems/lru-cache/description/
    private final int capacity;
    private final Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache_146_2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        tail = new DoubleLinkedNode();
        head = tail;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) return -1;
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        DoubleLinkedNode current = new DoubleLinkedNode(key, value);
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } else if (cache.size() == capacity) {
            DoubleLinkedNode firstNode = head.next;
            if (firstNode != null) {
                head.next = head.next.next;
                remove(firstNode);
            }
        }

        add(current);
    }


    private void add(DoubleLinkedNode node) {
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        if (head.next == null) {
            head.next = tail;
        }
        cache.put(node.key, node);
    }

    private void remove(DoubleLinkedNode node) {
        if (cache.containsKey(node.key)) {
            DoubleLinkedNode prev = node.prev;
            DoubleLinkedNode next = node.next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
            cache.remove(node.key);
        }
    }

    private class DoubleLinkedNode {
        int value;
        int key;
        DoubleLinkedNode prev = null;
        DoubleLinkedNode next = null;

        private DoubleLinkedNode(int key, int value) {
            this.value = value;
            this.key = key;
        }

        private DoubleLinkedNode() {}

    }

    public static void main(String[] args) {
        LRUCache_146_2 lRUCache = new LRUCache_146_2(2);
        lRUCache.put(2, 1);
        lRUCache.put(3, 2);
        lRUCache.get(3); // 2
        lRUCache.get(2); // 1
        lRUCache.put(4, 3);
        lRUCache.get(2); // return 1 // -1
        lRUCache.get(3); // return -1 // 2
        lRUCache.get(4); // return 3
    }
}
