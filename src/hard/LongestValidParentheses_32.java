package hard;

import java.util.Stack;

public class LongestValidParentheses_32 {
    // https://leetcode.com/problems/longest-valid-parentheses/description/
    public int longestValidParenthesesStack(String s) {
        if (s.length() == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else {
                stack.add(i);
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int max = 0, opened = 0, closed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') opened++;  else closed++;
            if (opened == closed) max = Math.max(max, opened + closed);
            else if (closed > opened) opened = closed = 0;
        }
        opened = closed = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') opened++; else closed++;
            if (opened == closed) max = Math.max(max, opened + closed);
            else if (opened > closed) opened = closed = 0;
        }
        return max;
    }
}
