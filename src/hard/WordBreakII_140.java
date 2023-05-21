package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII_140 {
    // https://leetcode.com/problems/word-break-ii/description/

    String string;
    List<String> answer;
    HashSet<String> words;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.string = s;
        this.answer = new ArrayList<>();
        this.words = new HashSet<>(wordDict);
        backTrack(new StringBuilder(), 0);
        return answer;
    }

    private void backTrack(StringBuilder builder, int index) {
        if (index > string.length()) return;
        if (index == string.length()) {
            answer.add(builder.toString());
            return;
        }
        for (int end = index; end < string.length(); end++) {
            String temp = string.substring(index, end + 1);
            if (words.contains(temp)) {
                int currentLength = builder.length();
                if (builder.length() != 0) {
                    builder.append(" ");
                }
                builder.append(temp);
                backTrack(builder, index + temp.length());
                builder.delete(currentLength, builder.length());
            }
        }
    }


}
