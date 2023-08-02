package hard;

import java.util.List;
import java.util.Map;

public class ValidNumber_65 {
    // https://leetcode.com/problems/valid-number/description/

    private static final List<Map<String, Integer>> dfa = List.of(
            Map.of("digit", 1, "dot", 2, "sign", 3), // start 0
            Map.of("digit", 1, "dot", 4, "exponent", 5), // digit 1
            Map.of("digit", 4),  // dot 2
            Map.of("digit", 1, "dot", 2), // sign 3
            Map.of("digit", 4, "exponent", 5), // after dot 4
            Map.of("digit", 6, "sign", 6), // after exponent 5
            Map.of("digit", 6) // last digit 6
    );

    public boolean isNumber(String s) {
        if (s.isEmpty()) return false;
        int currentState = 0;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            String group;
            if (Character.isDigit(symbol)) {
                group = "digit";
            } else if (symbol == '.') {
                group = "dot";
            } else if (symbol == 'e' || symbol == 'E') {
                group = "exponent";
            } else if (symbol == '-' || symbol == '+') {
                group = "sign";
            } else {
                return false;
            }
            if (!dfa.get(currentState).containsKey(group)) return false;
            currentState = dfa.get(currentState).get(group);
        }
        return Character.isDigit(s.charAt(s.length() - 1)) ||  currentState == 4;
    }
}
