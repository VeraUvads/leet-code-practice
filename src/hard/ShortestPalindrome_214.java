package hard;

public class ShortestPalindrome_214 {

    public String shortestPalindrome(String s) {
        // a a c e c a a a # a a a c e c a a
        // 0 1 0 0 0 1 2 2 0 1 2 2 3 4 5 6 7


        // a a a c e c a a # a a c e c a a a
        // 0 1 2 0 0 0 1 2 0 1 2 0 0 0 1 2 3
        if (s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.insert(0, s);
        sb.insert(s.length(), "#");
        String newStr = sb.toString();
        int[] LPS = lps(newStr);
        return new StringBuilder(s.substring(LPS[LPS.length - 1])).reverse() + s;
    }

    private int[] lps(String word) {
        int[] LPS = new int[word.length()];
        int start = 0, end = 1;
        while (end < word.length()) {
            if (word.charAt(start) == word.charAt(end)) {
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
        return LPS;
    }

}
