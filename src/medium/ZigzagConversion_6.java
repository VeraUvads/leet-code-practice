package medium;

public class ZigzagConversion_6 {
    // https://leetcode.com/problems/zigzag-conversion/description/

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        int defaultShift = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                builder.append(s.charAt(index));
                int secondIndex = index + defaultShift - i * 2;
                if (i != 0 && i != numRows - 1 && secondIndex < s.length()) {
                    builder.append(s.charAt(secondIndex));
                }
                index += defaultShift;
            }
        }
        return builder.toString();
    }
}
