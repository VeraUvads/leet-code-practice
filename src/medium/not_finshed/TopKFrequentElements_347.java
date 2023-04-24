package medium.not_finshed;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements_347 {
    // https://leetcode.com/problems/top-k-frequent-elements/

    // non optimal
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for (int num : nums) {
            bucket.put(num, bucket.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> max = null;
            for (Map.Entry<Integer, Integer> entry : bucket.entrySet()) { // num : count
                if (max == null || max.getValue() < entry.getValue()) {
                    max = entry;
                }
            }
            answer[i] = max.getKey();
            bucket.remove(max.getKey());
        }
        return answer;
    }
}
