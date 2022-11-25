package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

    // https://leetcode.com/problems/fizz-buzz/description/

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String builder = "";
            if (i % 3 == 0) {
                builder += "Fizz";
            }
            if (i % 5 == 0) {
                builder += "Buzz";
            }

            if (builder.length() == 0) {
                builder += String.valueOf(i);
            }

            list.add(builder);
        }
        return list;
    }
}
