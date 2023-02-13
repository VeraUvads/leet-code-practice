package hard;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache_460 {
    // https://leetcode.com/problems/lfu-cache/description/?envType=study-plan&id=level-3
    class LFUCache {

        private HashMap<Integer, Node> byKey;
        private HashMap<Integer, LinkedHashSet<Integer>> byCounter;
        private int capacity;
        private int min;

        public LFUCache(int capacity) {
            byKey = new HashMap<>();
            byCounter = new HashMap<>();
            this.capacity = capacity;
            min = 0;
        }

        public int get(int key) {
            Node node = getNode(key);
            if (node == null) return -1;
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (!byKey.containsKey(key) && byKey.size() == capacity){
                removeLFU();
            }
            Node node = getNode(key);
            if (node == null) {
                node = new Node(key, value);
                byKey.put(key, node);
                byCounter.putIfAbsent(node.counter, new LinkedHashSet<>());
                byCounter.get(node.counter).add(key);
                min = 1;
            } else {
                node.value = value;
            }
        }

        private Node getNode(int key) {
            Node node = byKey.getOrDefault(key, null);
            if (node == null) return null;
            byCounter.get(node.counter).remove(key);
            node.counter++;
            byCounter.putIfAbsent(node.counter, new LinkedHashSet<>());
            byCounter.get(node.counter).add(key);
            if (byCounter.containsKey(min) && byCounter.get(min).isEmpty()) {
                min++;
            }
            return node;
        }

        public void removeLFU() {
            LinkedHashSet<Integer> LFUKeys = byCounter.get(min);
            Integer LFUKey = LFUKeys.iterator().next();
            LFUKeys.remove(LFUKey);
            byKey.remove(LFUKey);
        }

        private class Node {
            int counter;
            int value;
            int key;

            Node() {}
            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.counter = 1;
            }
        }
    }
}
