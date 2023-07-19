package medium;

public class OneEditDistance_161 {
    // https://leetcode.com/problems/one-edit-distance/description/

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() < t.length()) { // s always bigger
            String temp = t;
            t = s;
            s = temp;
        }
        int sPointer = 0, tPointer = 0;
        while  (sPointer < s.length() && tPointer < t.length()) {
            char sSymbol = s.charAt(sPointer);
            char tSymbol = t.charAt(tPointer);
            if (sSymbol != tSymbol) {
                return s.substring(sPointer + 1).equals(t.substring(tPointer))  ||
                        s.substring(sPointer + 1).equals(t.substring(tPointer + 1));
            } else {
                sPointer++;
                tPointer++;
            }
        }
        return sPointer == s.length() - 1;
    }
}
