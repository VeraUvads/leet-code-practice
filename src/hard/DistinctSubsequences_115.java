package hard;

import java.util.HashMap;

public class DistinctSubsequences_115 {
    // https://leetcode.com/problems/distinct-subsequences/description/

    HashMap<String, Integer> memo = new HashMap<>();

    public int numDistinct(String s, String t) {
        return backTracking(s, 0,  t, 0);
    }

    private int backTracking(String s, int sIndex,  String t, int tIndex)  {
        if (t.length() == tIndex) return 1;
        if (s.length() == sIndex) return 0;
        String key = sIndex + "/" + tIndex;
        if (memo.containsKey(key))  return memo.get(key);
        int result = backTracking(s, sIndex + 1, t, tIndex);
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            result += backTracking(s, sIndex + 1, t, tIndex + 1);
        }
        memo.put(key, result);
        return result;
    }

}
