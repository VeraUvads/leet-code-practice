package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJustification_68 {
    // https://leetcode.com/problems/text-justification/description/
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int length = 0;
            int start = index;
            while (index < words.length && length + words[index].length() + (index - start) <= maxWidth) {
                length += words[index].length();
                index++;
            }
            answer.add(getString(start, index - 1, length, maxWidth, words, index == words.length));
        }
        return answer;
    }

    private String getString(int start, int end, int length, int maxWidth, String[] words, boolean isLast) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i != start && isLast) {
                builder.append(" ");
            } else if (i != start) {
                double wordsCount = end - i + 1;
                int left = maxWidth - builder.length();
                int spaces = left - length;
                int space = (int) Math.ceil(spaces / wordsCount);
                builder.append(Collections.nCopies(space, " "));
            }
            builder.append(words[i]);
            length -= words[i].length();
        }

        int spaces = maxWidth - builder.length();
        if (spaces > 0) {
            builder.append(Collections.nCopies(spaces, " "));
        }
        return builder.toString();
    }
}
