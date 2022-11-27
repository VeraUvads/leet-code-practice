package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
   // https://leetcode.com/problems/isomorphic-strings/

    public  static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return transformString(s).equals(transformString(t));
    }

    public static String transformString(String string) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder clone = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (!map.containsKey(current)) {
                map.put(current, i);
            }
            clone.append(map.get(current));
            clone.append(" ");
        }
        System.out.println(clone);
        return clone.toString();
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
