package medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146_1 extends LinkedHashMap<Integer, Integer> {
    // https://leetcode.com/problems/lru-cache/description/
    private int capacity;

    public LRUCache_146_1(int capacity) {
        super(capacity, 1F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() >= capacity;
    }

    public static void main(String[] args) {
        LRUCache_146_1 lRUCache = new LRUCache_146_1(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);     // return 4
    }
}
