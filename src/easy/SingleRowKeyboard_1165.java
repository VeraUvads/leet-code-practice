package easy;

public class SingleRowKeyboard_1165 {
    // https://leetcode.com/problems/single-row-keyboard/description/
    public int calculateTime(String keyboard, String word) {
        if (word.length() == 0) return 0;
        int[] positions = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            positions[keyboard.charAt(i) - 'a'] = i;
        }
        int counter = 0;
        int prev = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int currPosition = positions[letter - 'a'];
            counter += Math.abs(prev - currPosition);
            prev = currPosition;
        }
        return counter;
    }
}
