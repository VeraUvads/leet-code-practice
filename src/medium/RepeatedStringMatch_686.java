package medium;

public class RepeatedStringMatch_686 {
    // https://leetcode.com/problems/repeated-string-match/description/

    public int repeatedStringMatch(String pattern, String string) {
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        while (builder.length() < string.length()) {
            counter++;
            builder.append(pattern);
        }
        if (builder.toString().contains(string)) return counter;
        builder.append(pattern);
        if (builder.toString().contains(string)) return ++counter;
        return -1;
    }

    private int[] lps(String string) {
        int[] LPS = new int[string.length()];
        int start = 0;
        int end = 1;
        while (end < string.length()) {
            if (string.charAt(start) == string.charAt(end)) {
                LPS[end] = start + 1;
                start++;
                end++;
            } else if (start == 0) {
                end++;
            } else {
                start = LPS[start - 1];
            }
        }
        return LPS;
    }
}
