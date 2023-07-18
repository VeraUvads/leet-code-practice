package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses_301 {
    String string;
    Set<String> answer;
    int minimumRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        this.string = s;
        this.answer = new HashSet<>();
        backTrack(0, new StringBuilder(), 0, 0, 0);
        return new ArrayList<>(answer);
    }

    private void backTrack(int index, StringBuilder builder, int opened, int closed, int numberOfChanges) {
        if (index == string.length()) {
            if (opened == closed && numberOfChanges <= minimumRemoved) {
                if (numberOfChanges < minimumRemoved) {
                    minimumRemoved = numberOfChanges;
                    answer.clear();
                }
                answer.add(builder.toString());
            }
            return;
        }
        char symbol = string.charAt(index);
        if (symbol != '(' && symbol != ')') {
            builder.append(symbol);
            backTrack(index + 1, builder, opened, closed, numberOfChanges);
            builder.deleteCharAt(builder.length() - 1);
        } else if (symbol == ')' && opened <= closed) {
            backTrack(index + 1, builder, opened, closed, numberOfChanges + 1);
        } else {
            backTrack(index + 1, builder, opened, closed, numberOfChanges + 1);
            builder.append(symbol);
            if (symbol == ')') {
                backTrack(index + 1, builder, opened, closed + 1, numberOfChanges);
            } else {
                backTrack(index + 1, builder, opened + 1, closed, numberOfChanges);
            }
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
