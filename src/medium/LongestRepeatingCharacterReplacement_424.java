package medium;

public class LongestRepeatingCharacterReplacement_424 {
    // https://leetcode.com/problems/longest-repeating-character-replacement/?envType=study-plan&id=level-1

    public static int characterReplacement(String s, int k) {
        int[] letters =  new int[26];
        int maxFrequency = 0;
        int result = 0;

        for (int i = 0,  j = 0; j < s.length(); j++) {
            int current =  s.charAt(j) - 'A';
            letters[current]++;
            maxFrequency  = Math.max(maxFrequency, letters[current]);
            if (j + 1 - i  - maxFrequency > k) {
                letters[(int)(s.charAt(i) - 'A')]--;
                i++;
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }


    public static void main(String[] args) {
        characterReplacement("AABABBA",  1);
    }
}
