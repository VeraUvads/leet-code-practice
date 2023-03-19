package medium;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    // https://leetcode.com/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min = 1;
        int speed = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canEat(mid, piles) > h) {
                min = mid + 1;
            } else {
                speed = Math.min(speed, mid);
                max = mid - 1;
            }
        }
        return speed;
    }

    private long canEat(int speed, int[] piles) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            hours += pile / speed;
            if (pile % speed != 0)  hours++;
        }
        return hours;
    }
}
