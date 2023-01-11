package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
// https://leetcode.com/problems/lru-cache/description/

public class LRUCache_146_2 extends LinkedHashMap<Integer, Integer> {

    private final int capacity;
    private final Map<Integer, DoubleLinkedNode> cache;
    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;

    public LRUCache_146_2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new DoubleLinkedNode();
        tail = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = getNode(key);
        if (node == null) return -1;
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new DoubleLinkedNode(key, value);
        add(node);
    }

    private DoubleLinkedNode getNode(int key) {
        if (!cache.containsKey(key)) return null;
        DoubleLinkedNode node = cache.get(key);
        if (node.key != tail.key) {
            remove(node);
            add(node);
        }
        return node;
    }


    private void add(DoubleLinkedNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
        cache.put(node.key, node);
        if (cache.size() > capacity) {
            remove(head.next);
        }
    }

    private boolean remove(DoubleLinkedNode node) {
        if (node == null) return false;
        cache.remove(node.key);
        DoubleLinkedNode prev = node.prev;
        prev.next = node.next;
        if (node.key == tail.key) {
            tail.next = prev;
        }
        if (node.next != null) {
            node.next.prev = prev;
        }
        return true;
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
        LRUCache_146_2 lRUCache = new LRUCache_146_2(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
    }
}
