package easy;

import java.util.Arrays;

public class DistributeMoneyToMaximumChildren_2591 {
    // https://leetcode.com/problems/distribute-money-to-maximum-children/description/
    public int distMoney(int money, int children) {
        money -= children;
        if (money < 0) return -1;
        int[] distr = new int[children];
        Arrays.fill(distr, 1);

        int index = 0;
        while (money != 0) {
            if (money > 7 && distr[index] == 1) {
                distr[index++] += 7;
                money -=7;
            } else if (money == 3 && distr[index] == 1) {
                distr[index++] += 2;
                money -= 2;
            } else {
                distr[index++] += money;
                money -= money;
            }
            index = index % children;
        }
        int answer = 0;
        for (int i = 0; i < children; i++) {
            if (distr[i] == 8) answer++;
        }
        return answer;
    }
}
