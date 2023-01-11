package medium;

import java.util.*;

public class GroupAnagrams_49 {
    // https://leetcode.com/problems/group-anagrams/description/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> answer = new HashMap<>();
        int[] lowercases = new int[26];
        StringBuilder builder = new StringBuilder();
        for (String str : strs) { // O(N)
            Arrays.fill(lowercases, 0); //  O(1)
            builder.setLength(0);
            for (int i = 0; i < str.length(); i++) { //  O(K) - K наибольшая длинна
                char curr = str.charAt(i);
                lowercases[curr - 'a']++;
            }
            for (int index : lowercases) {  //  O(1)
                builder.append('a' + index);
            }
            List<String> arr = answer.getOrDefault(builder.toString(), new ArrayList<>());
            arr.add(str);
            answer.put(builder.toString(), arr);
        }
        return new ArrayList<>(answer.values());
    }
}

