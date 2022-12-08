package medium;

public class BullsAndCows_299 {
    // https://leetcode.com/problems/bulls-and-cows/description/

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cow = 0;
        int[] digits = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int first = secret.charAt(i) - '0';
            int second  = guess.charAt(i) - '0';
            if (first == second) {
                bulls++;
            } else {
                if (digits[first] < 0) {
                    cow++;
                }
                if (digits[second] >  0) {
                    cow++;
                }
                digits[first]++;
                digits[second]--;
            }
        }

        return bulls + "A"  + cow + "B";
    }

    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cow = 0;
        int[] digitsSecret = new int[10];
        int[] digitsGuess = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char first = secret.charAt(i);
            char second  = guess.charAt(i);
            if (first == second) {
                bulls++;
            } else {
                digitsSecret[(int)(first - '0')]++;
                digitsGuess[(int)(second - '0')]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(digitsSecret[i], digitsGuess[i]);
        }

        return bulls + "A"  + cow + "B";
    }
}
