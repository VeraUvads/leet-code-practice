package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
    // https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/

    public int lengthOfLongestSubstringTwoDistinct(String string) {
        HashMap<Character, Integer> map = new HashMap<>();// letter - right index
        int answer = 0;
        for (int end = 0,  start = 0; end < string.length(); end++) {
            char letter = string.charAt(end);
            map.put(letter, end);
            if (map.size() > 2) {
                Map.Entry<Character, Integer> forRemove = null;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (forRemove == null || forRemove.getValue() > entry.getValue()) {
                        forRemove = entry;
                    }
                }
                start = map.remove(forRemove.getKey()) + 1;
            }
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}
