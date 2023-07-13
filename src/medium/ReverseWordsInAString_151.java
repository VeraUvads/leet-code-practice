package medium;

public class ReverseWordsInAString_151 {
    // https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
    /**
     the sky is blue

     eulb si yks eht
     blue is sky the

     "  hello world  "
     */
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, s.length() - 1);
        Integer start = null;
        for (int i = 0; i < s.length(); i++) {
            char symbol = arr[i];
            if (symbol != ' ' && start == null) {
                start = i;
            }
            if (symbol == ' ' && start != null) {
                reverse(arr, start, i - 1);
                start = null;
            }
        }
        if (start != null) reverse(arr, start, s.length() - 1);

        int left = 0, right = s.length() - 1;
        while (left <= right && arr[left] == ' ') ++left;
        while (left <= right && arr[right] == ' ') --right;

        StringBuilder builder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            char symbol = arr[i];
            if (symbol == ' ' && (i == 0 || arr[i - 1] == ' ')) continue;
            builder.append(symbol);
        }
        return builder.toString();
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
