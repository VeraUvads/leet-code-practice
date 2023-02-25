package medium;

public class RepeatedSubstringPattern_459 {
    // https://leetcode.com/problems/repeated-substring-pattern/description/

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) return false;
        int[] LPS = new int[n];
        int start = 0, end = 1;
        while (end < n) {
            if (s.charAt(start) == s.charAt(end)) {
                LPS[end] = start + 1;
                start++;
                end++;
            } else if (start == 0) {
                LPS[end] = 0;
                end++;
            } else {
                start = LPS[start - 1];
            }
        }
        int lp = LPS[n - 1];
        String pattern = s.substring(lp, n - 1);
        return lp != 0 && s.startsWith(pattern);
    }
}
