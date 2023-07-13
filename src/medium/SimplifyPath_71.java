package medium;

import java.util.LinkedList;

public class SimplifyPath_71 {
    // https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        LinkedList<String> stack = new LinkedList();
        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) stack.removeLast();
            } else {
                stack.add(component);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.removeFirst());
        }
        return result.toString();
    }
}
