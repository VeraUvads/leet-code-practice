package medium;

import java.util.Arrays;

public class TaskScheduler_621 {

    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char task: tasks) {
            frequency[task - 'A']++;
        }
        Arrays.sort(frequency);
        int maxFrequency = frequency[25];
        int idleTime = (maxFrequency - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idleTime -= Math.min(frequency[i], maxFrequency - 1);
        }
        if (idleTime < 0) idleTime = 0;
        return idleTime + tasks.length;
    }

    public int leastIntervalSecond(char[] tasks, int n) {
        int[] frequency = new int[26];
        for (char task: tasks) {
            frequency[task - 'A']++;
        }
        Arrays.sort(frequency);
        int maxFrequency = frequency[25];

        int result = (n + 1) * (maxFrequency - 1) + 1;
        for (int i = 24; i >= 0; i--)  {
            if (frequency[i] != maxFrequency) break;
            result++;
        }

        return Math.max(tasks.length, result);
    }
}
