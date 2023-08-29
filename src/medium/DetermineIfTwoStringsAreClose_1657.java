package medium;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose_1657 {
    // https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75

    public boolean closeStrings(String word1, String word2) {
        int[] letters1 = new int[26];
        int[] letters2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            letters1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            letters2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < letters1.length; i++) {
            int occurence1 = letters1[i];
            int occurence2 = letters2[i];
            if (occurence1 == 0 && occurence2 != 0 || occurence2 == 0 &&occurence1 != 0) {
                return false;
            }
        }
        Arrays.sort(letters1);
        Arrays.sort(letters2);
        for (int i = 0; i < letters1.length; i++) {
            if (letters1[i] != letters2[i]) return false;
        }
        return true;
    }
}
