package easy;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1, tPointer = t.length() - 1;
        int missS = 0, missT = 0;
        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                char first = s.charAt(sPointer);
                if (first == '#') {
                    sPointer--;
                    missS++;
                } else if(missS > 0) {
                    sPointer--;
                    missS--;
                } else {
                    break;
                }
            }

            while (tPointer >= 0) {
                char second = t.charAt(tPointer);
                if (second == '#') {
                    tPointer--;
                    missT++;
                } else if(missT > 0) {
                    tPointer--;
                    missT--;
                } else {
                    break;
                }
            }
            if (sPointer >= 0 && tPointer >= 0) {
                char first  = s.charAt(sPointer);
                char second = t.charAt(tPointer);
                if (first != second) return false;
            };
            if ((sPointer >= 0) != (tPointer >= 0)) return false;
            sPointer--; tPointer--;
        }
        return true;
    }

    public boolean backspaceCompareStack(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '#' ) {
                stack.add(string.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
