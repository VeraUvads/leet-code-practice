package easy;

public class LengthOfLastWord_58 {

    // https://leetcode.com/problems/length-of-last-word/

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char symbol = s.charAt(i);
            if (symbol != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        return length;
    }
}
