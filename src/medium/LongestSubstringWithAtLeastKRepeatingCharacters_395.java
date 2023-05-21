package medium;


public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {
    //https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

    public int longestSubstring(String s, int k) {
        int[] letters = new int[26];
        int max = 0;
        int uniqueCount = countUnique(s);

        for (int unique = 1; unique <= uniqueCount; unique++) {
            int[] map = new int[26];
            int start = 0, curUnique = 0, atLeastK = 0;
            for (int end = 0; end < s.length(); end++) {
                int endIndex = s.charAt(end) - 'a';
                if (map[endIndex]++ == 0) {
                    curUnique++;
                }
                if (map[endIndex] == k) {
                    atLeastK++;
                }
                while (curUnique > unique) {
                    int startIndex = s.charAt(start) - 'a';
                    if (map[startIndex]-- == k) atLeastK--;
                    if (map[startIndex] == 0) curUnique--;
                    start++;
                }
                if (atLeastK == curUnique) {
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
