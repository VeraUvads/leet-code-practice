package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {
    // https://leetcode.com/problems/longest-palindrome/description/?envType=study-plan&id=level-1

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        int counter = 0;
        int counterForSingle = 0;

        for (Character key : map.keySet()) {
            if (counterForSingle == 0) {
                counterForSingle = map.get(key) % 2;
            }
            counter += map.get(key) / 2;
        }

        return counter * 2 + counterForSingle;
    }
}
