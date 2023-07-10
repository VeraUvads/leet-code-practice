package hard;

import java.util.*;

public class AlienDictionary_269 {
    // https://leetcode.com/problems/alien-dictionary/description/?envType=featured-list&envId=top-interview-questions
    class Solution {
        public String alienOrder(String[] words) {
            HashMap<Character, ArrayList<Character>> adj = new HashMap<>();
            int[] inDegree = new int[26];
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    adj.put(c, new ArrayList<>());
                }
            }
            for (int i  = 0; i < words.length -  1; i++) {
                String word = words[i];
                String nextWord = words[i + 1];
                if (word.length() > nextWord.length() && word.startsWith(nextWord)) {
                    return "";
                }
                for (int j = 0; j < Math.min(word.length(), nextWord.length()); j++) {
                    char letter = word.charAt(j);
                    char nextWordLetter = nextWord.charAt(j);
                    if (nextWordLetter != letter) {
                        adj.get(letter).add(nextWordLetter);
                        break;
                    }
                }
            }
            for (Map.Entry<Character, ArrayList<Character>> entry : adj.entrySet()) {
                Character letter = entry.getKey();
                ArrayList<Character> tos = entry.getValue();
                for (Character to : tos) {
                    inDegree[to - 'a']++;
                }
            }
            StringBuilder builder = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (Character letter : adj.keySet()) {
                if (inDegree[letter - 'a'] == 0) {
                    queue.add(letter);
                }
            }
            while (!queue.isEmpty()) {
                Character from = queue.poll();
                builder.append(from);
                for (Character to : adj.get(from)) {
                    inDegree[to - 'a']--;
                    if (inDegree[to - 'a'] == 0) {
                        queue.add(to);
                    }
                }
            }
            if (builder.length() < adj.size()) return "";
            return builder.toString();
        }
    }
}
