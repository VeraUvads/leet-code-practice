package medium;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords_2131 {
    // https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/?envType=study-plan&id=level-2
    public int longestPalindromeHashMap(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)   {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int counter = 0;
        boolean centerAdded = false;
        for (String word : map.keySet()) {
            Integer count = map.get(word);
            if (word.charAt(0) == word.charAt(1)) {
                if (count % 2 == 0) {
                    counter += count;
                } else {
                    counter += count - 1;
                    centerAdded = true;
                }
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (map.containsKey(reversedWord) ) {
                    counter += 2 * Math.min(count, map.get(reversedWord));;
                }
            }
        }
        if (centerAdded) {
            counter++;
        }
        return 2 * counter;
    }

    public int longestPalindrome(String[] words) {
        int[][] alphabet = new int[26][26];
        for (String word : words) {
            alphabet[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        int counter = 0;
        boolean centerAdded = false;

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = i; j < alphabet[0].length; j++) {
                if (i == j) {
                    counter += alphabet[i][j] / 2 * 2;
                    if (alphabet[i][j] % 2 != 0) centerAdded = true;
                } else {
                    counter += 2 * Math.min(alphabet[i][j], alphabet[j][i]);
                }
            }
        }

        if (centerAdded) {
            counter++;
        }
        return 2 * counter;
    }
}
