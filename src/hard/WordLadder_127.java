package hard;

import java.util.*;

public class WordLadder_127 {
    // https://leetcode.com/problems/word-ladder/description/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> wordsByPatterns = new HashMap<>();
        HashMap<String, List<String>> patternsByWord = new HashMap<>();
        wordList.add(beginWord);

        StringBuilder builder = new StringBuilder();
        for (String word : wordList) { // O(N)
            patternsByWord.putIfAbsent(word, new ArrayList<>());
            for (int i = 0; i < word.length(); i++) { // O(M)
                builder.append(word.substring(0, i));
                builder.append("*");
                builder.append(word.substring(i + 1, word.length()));
                String pattern = builder.toString();  // O(M)
                patternsByWord.get(word).add(pattern); // O(M)
                wordsByPatterns.putIfAbsent(pattern, new ArrayList<>());
                wordsByPatterns.get(pattern).add(word);
                builder.setLength(0);
            }
        } // O(N*M)
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int counter = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) return counter;
                for (String pattern : patternsByWord.get(word)) { // O(M)
                    for (String nextWord : wordsByPatterns.get(pattern)) { // O(N) // O(M)
                        if (visited.add(nextWord)) {
                            queue.add(nextWord);
                        }
                    }
                }
                size--;
            }
            counter++;
        }
        return 0;
    }
}
