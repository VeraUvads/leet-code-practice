package medium;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {
    //https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

    public int longestSubstring(String s, int k) {
        int[] letters = new int[26];
        int max = 0;
        int uniqueCount = countUnique(s);

        for (int unique = 1; unique <= uniqueCount; unique++) {
            HashMap<Character, Integer> map = new HashMap<>(26);
            int start = 0, atLeastK = 0;
            for (int end = 0; end < s.length(); end++) {
                char endSymbol = s.charAt(end);
                int count = map.getOrDefault(endSymbol, 0) + 1;
                map.put(endSymbol, count);
                if (count == k) {
                    atLeastK++;
                }
                while (map.size() > unique) {
                    char startSymbol = s.charAt(start);
                    count = map.get(startSymbol) - 1;
                    map.put(startSymbol, count);
                    if (count + 1 == k) atLeastK--;
                    if (count == 0) {
                        map.remove(startSymbol);
                    }
                    start++;
                }
                if (atLeastK == map.size()) {
                    max = Math.max(max, end - start + 1);
                }
            }
        }
        return max;
    }

    private int countUnique(String s) {
        boolean[] map = new boolean[26];
        int unique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a']) continue;
            unique++;
            map[s.charAt(i) - 'a'] = true;
        }
        return unique;
    }
}
