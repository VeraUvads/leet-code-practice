package hard;

import java.util.HashMap;

public class MinimumWindowSubstring_76 {
    // https://leetcode.com/problems/minimum-window-substring/description/

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            int count = tMap.getOrDefault(letter, 0);
            tMap.put(letter, ++count);
        }
        int[] answer = {Integer.MAX_VALUE, 0, 0};
        int requiredLength = tMap.size();
        HashMap<Character, Integer> window = new HashMap<>();
        int formed = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            char letter = s.charAt(end);
            int count = window.getOrDefault(letter, 0);
            window.put(letter, ++count);
            if (tMap.containsKey(letter) && window.get(letter).intValue() == tMap.get(letter).intValue()) {
                formed++;
            }
            while (start <= end && formed == requiredLength) {
                if (end - start + 1 < answer[0]) {
                    answer[0] = end - start + 1;
                    answer[1] = start;
                    answer[2] = end;
                }
                letter = s.charAt(start);
                window.put(letter, window.get(letter) - 1);

                if (tMap.containsKey(letter) && window.get(letter) < tMap.get(letter)) {
                    formed--;
                }
                start++;
            }
            end++;
        }
        return answer[0] == Integer.MAX_VALUE ? "" : s.substring(answer[1], answer[2] + 1);
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
