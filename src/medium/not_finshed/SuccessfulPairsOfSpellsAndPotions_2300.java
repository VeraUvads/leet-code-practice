package medium.not_finshed;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {
    //https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            answer[i] = countSuccess(spells[i], potions, success);
        }
        return answer;
    }

    private int countSuccess(int spell, int[] potions, long success) {
        int start = 0;
        int end = potions.length;
        while (start < end) {
            int midIndex = start + (end - start) / 2;
            long mid = spell * potions[midIndex];
            if (mid < success) {
                start = midIndex + 1;
            } else {
                end = midIndex;
            }
        }
        return potions.length - end;
    }
}
