package medium;

public class CountAndSay_38 {
    // https://leetcode.com/problems/count-and-say/

    public String countAndSayIterative(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append("1");
        for (int i = 1; i < n; i++) {
            String prevString = builder.toString();
            builder.setLength(0);

            char prev = prevString.charAt(0);
            int counter = 1;

            for (int j = 1; j < prevString.length(); j++) {
                if (prev == prevString.charAt(j)) {
                    counter++;
                } else {
                    builder.append(counter);
                    builder.append(prev);
                    prev = prevString.charAt(j);
                    counter = 1;
                }
            }

            builder.append(counter);
            builder.append(prev);
        }

        return builder.toString();
    }

    StringBuilder builder = new StringBuilder();

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prevString = countAndSay(n - 1);
        builder.setLength(0);

        char prev = prevString.charAt(0);
        int counter = 1;
        for (int i = 1; i < prevString.length(); i++) {
            if (prev == prevString.charAt(i)) {
                counter++;
            } else {
                builder.append(counter);
                builder.append(prev);
                prev = prevString.charAt(i);
                counter = 1;
            }
        }

        builder.append(counter);
        builder.append(prev);

        return builder.toString();
    }
}
