package easy;

import java.util.PriorityQueue;

public class ValidPalindrome_125 {
    // https://leetcode.com/problems/valid-palindrome/description/

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            if (left >= right) break;
            if (
                    Character.toLowerCase(s.charAt(left++)) !=
                            Character.toLowerCase(s.charAt(right--))
            ) return false;
        }
        PriorityQueue<Integer> queue = new PriorityQueue();
        return true;
    }

    private boolean isAlphanumeric(char symbol) {
        return Character.isLetterOrDigit(symbol);
    }
}
