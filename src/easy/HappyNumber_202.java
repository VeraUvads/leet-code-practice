package easy;

import java.util.HashMap;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = findNext(n);
        while (slow != fast && fast != 1)  {
            slow = findNext(slow);
            fast = findNext(findNext(fast));
        }

        return fast == 1;
    }

    private int findNext(int n) {
        int helper = 0;
        while (n != 0) {
            int digit = n % 10;
            helper += digit * digit;
            n = n / 10;
        }
        return helper;
    }

    public boolean isHappyMap(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);
        while (n != 1) {
            int helper = 0;
            while (n != 0) {
                int digit = n % 10;
                helper += digit * digit;
                n = n / 10;
            }
            if (map.containsKey(helper)) {
                return false;
            } else {
                n = helper;
                map.put(n, 1);
            }
        }
        return true;
    }

}
