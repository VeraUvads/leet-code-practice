package medium;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore_981 {
    // https://leetcode.com/problems/time-based-key-value-store/description/

    class TimeMapBinary {
        private HashMap<String, List<Pair<String, Integer>>> map;

        public TimeMapBinary() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(map.get(key), timestamp);
        }

        private String binarySearch(List<Pair<String, Integer>> list, int target) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int midIndex = (left + right) / 2;
                Pair<String, Integer> mid = list.get(midIndex);
                int curr = mid.getSecond();
                if (curr <= target) {
                    left = midIndex + 1;
                } else {
                    right = midIndex;
                }
            }
            if (right == 0) return "";
            return list.get(right - 1).getFirst();
        }
    }

    class TimeMap {
        private HashMap<String, List<Pair<String, Integer>>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair<String, Integer>> list = map.get(key);
            for (int i = list.size() - 1; i >= 0; i--) {
                Pair<String, Integer> pair = list.get(i);
                if (pair.getSecond() <= timestamp) {
                    return pair.getFirst();
                }
            }
            return "";
        }
    }
}
