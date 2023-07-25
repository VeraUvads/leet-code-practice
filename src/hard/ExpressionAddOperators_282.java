package hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
    // https://leetcode.com/problems/expression-add-operators/description/

    List<String> answer;
    String num;
    long target;

    public List<String> addOperators(String num, long target) {
        this.answer = new ArrayList<>();
        if (num.length() == 0) return answer;
        this.target = target;
        this.num = num;
        backTrack(0, new StringBuilder(), 0, 0);
        return answer;
    }

    private void backTrack(int start, StringBuilder builder, long evaluate, long curr) {
        if (start == num.length()) {
            if (evaluate + curr == target) {
                answer.add(builder.toString());
            }
            return;
        }
        long next = 0;
        int size = builder.length();
        for (int index = start; index < num.length(); index++) {
            if (index != start && num.charAt(start) == '0') {
                break;
            }
            next = next * 10 + num.charAt(index) - '0';
            if (start == 0) {
                builder.append(next);
                backTrack(index + 1, builder, 0, next);
                builder.setLength(size);
            } else {
                builder.append("*");
                builder.append(next);
                backTrack(index + 1, builder, evaluate, curr * next);
                builder.setLength(size);
                builder.append("+");
                builder.append(next);
                backTrack(index + 1, builder, evaluate + curr, next);
                builder.setLength(size);
                builder.append("-");
                builder.append(next);
                backTrack(index + 1, builder, evaluate + curr, -next);
                builder.setLength(size);
            }
        }
    }
}
