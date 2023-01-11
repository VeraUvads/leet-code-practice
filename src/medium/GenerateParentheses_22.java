package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return answer;
    }

    private void backtrack(StringBuilder builder,  int open, int close, int max) {
        if (open == max && close == max) {
            if (builder.length() != 0) {
                answer.add(builder.toString());
            }
            return;
        }
        if (open < max) {
            builder.append('(');
            backtrack(builder, open + 1, close, max);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (close < open) {
            builder.append(')');
            backtrack(builder, open, close + 1, max);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
