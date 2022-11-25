package medium;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            if (hashMap.containsKey(current)) {
                i = Math.max(hashMap.get(current) + 1, i);
            }
            answer = Math.max(j - i + 1, answer);
            hashMap.put(current, j);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
