package medium;

import java.util.Stack;

public class DailyTemperatures_739 {
    // https://leetcode.com/problems/daily-temperatures/description/

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int max = 0;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            if (currentTemp >= max) {
                max = currentTemp;
                continue;
            }
            int days = 1;
            while (temperatures[i + days] <= currentTemp) {
                days += answer[i + days];
            }
            answer[i] = days;
        }
        return answer;
    }

    // Not optimized memory
    public int[] dailyTemperaturesStack(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.add(i);
        }
        return answer;
    }

    // Time Limit Exceeded
    public int[] dailyTemperaturesTwoPointers(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int right = temperatures.length - 1;
        int left = right - 1;

        while (left >= 0) {
            if (temperatures[left] < temperatures[right]) {
                answer[left] = right - left;
            } else {
                while (right < temperatures.length && temperatures[left] >= temperatures[right]) {
                    right++;
                }
                if (right != temperatures.length) {
                    answer[left] = right - left;
                }
            }
            right = left;
            left--;
        }
        return answer;
    }
}
