package medium;

public class StringCompression_443 {
    // https://leetcode.com/problems/string-compression/
    public int compress(char[] chars) {
        int pointer = 0, counter = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == chars[i - 1]) {
                counter++;
            } else {
                chars[pointer++] = chars[i - 1];
                if (counter > 0) {
                    for (char c : Integer.toString(counter + 1).toCharArray()) {
                        chars[pointer++] = c;
                    }
                }
                counter = 0;
            }
        }
        return pointer;
    }
}
