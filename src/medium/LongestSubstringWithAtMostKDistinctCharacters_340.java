package medium;

import java.util.HashMap;
// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char symbol = s.charAt(end);
            map.put(symbol, map.getOrDefault(symbol, 0) + 1);
            while (map.size() > k && start <= end) {
                char startSymbol = s.charAt(start++);
                int symbolCount = map.get(startSymbol);
                map.put(startSymbol, symbolCount - 1);
                if (map.get(startSymbol) == 0) {
                    map.remove(startSymbol);
                }
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
