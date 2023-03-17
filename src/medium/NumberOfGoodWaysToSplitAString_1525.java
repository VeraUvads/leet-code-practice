package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString_1525 {
    // https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/

    public int numSplits(String string) {
        if (string.length() < 2) return 0;
        Set<Character> leftPart = new HashSet<>();
        HashMap<Character, Integer> rightPart = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            rightPart.put(letter, rightPart.getOrDefault(letter, 0) + 1);
        }
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            int countIRightPart = rightPart.get(letter) - 1;
            if (countIRightPart == 0) {
                rightPart.remove(letter);
            } else {
                rightPart.put(letter, countIRightPart);
            }
            leftPart.add(letter);
            if (rightPart.keySet().size() == leftPart.size()) {
                counter++;
            }
        }
        return counter;
    }

}
