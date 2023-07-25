package hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
    // https://leetcode.com/problems/expression-add-operators/description/

    List<String> answer;
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        this.answer = new ArrayList<>();
        if (num.length() == 0) return answer;
        this.target =  target;
        this.num = num;
        backTrack(0, new StringBuilder(), 0, 0);
        return answer;
    }

    private void backTrack(int index, StringBuilder builder, int evaluate, int curr) {
        if (index == num.length()) {
            if (evaluate + curr == target) {
                char last = builder.charAt(builder.length() - 1);
                builder.deleteCharAt(builder.length() - 1);
                answer.add(builder.toString());
                builder.append(last);
            }
            return;
        }
        int next = num.charAt(index) - '0';
        builder.append(next);
        if (index == 0) {
            backTrack(index + 1, builder, next, curr);
        } else {
            builder.append("*");
            backTrack(index + 1, builder, evaluate, curr * next);
            builder.deleteCharAt(builder.length() - 1);
            builder.append("+");
            backTrack(index + 1, builder, evaluate + curr, next);
            builder.deleteCharAt(builder.length() - 1);
            builder.append("-");
            backTrack(index + 1, builder, evaluate + curr, -next);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.deleteCharAt(builder.length() - 1);
    }
}
