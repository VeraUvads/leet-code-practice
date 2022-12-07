package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString_438 {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s.length() < p.length()) return list;
        int[] sCounter  = new int[26];
        int[] pCounter  = new int[26];
        for (int index = 0; index < p.length();  index++)  {
            int current = (int) (p.charAt(index)  - 'a');
            pCounter[current]++;
        }
        for (int i = 0; i < s.length();  i++)  {
            sCounter[(int)(s.charAt(i) - 'a')]++;
            if (i >= p.length()) {
                sCounter[(int)(s.charAt(i - p.length()) - 'a')]--;
            }

            if (Arrays.equals(pCounter, sCounter)) {
                list.add(i - p.length() + 1);
            }
        }

        return list;
    }
}
