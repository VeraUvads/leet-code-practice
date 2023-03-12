package hard;

import java.util.HashMap;

public class CrackingTheSafe_753 {
    // https://leetcode.com/problems/cracking-the-safe/description/

    public String crackSafe(int length, int range) {
        if (length == 1) return "0123456789".substring(0, range);
        if (range == 1) return "0000".substring(0, length);

        HashMap<String, Integer> suffixMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            builder.append("0");
        }
        while (true) {
            String suffix = builder.substring(builder.length() - length + 1);
            int next = suffixMap.getOrDefault(suffix, range) - 1;
            if (next < 0) break;
            builder.append(next);
            suffixMap.put(suffix, next);
        }
        return builder.toString();
    }

//         "0123456789"
//          len == 4  range = 2
    // n! / (n - k)!
//         "0002" -> 0022 -> 0222 -> 2222 -> 2221 -> 2220 -> 2202 -> 2022 - > 0221 -> 2212
//          0001 -> 0012, 0011, 0010
//          0000 -> 0002, 0001, 0000


}
