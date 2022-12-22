package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule_II_210 {

    // https://leetcode.com/problems/course-schedule-ii/description/

    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] result;
    int[] color;
    int pointer = 0;
    boolean isPossible = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        color = new int[numCourses];
        for (int[] current : prerequisites) {
            List<Integer> list = map.getOrDefault(current[0], new ArrayList<>());
            list.add(current[1]);
            map.put(current[0], list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == WHITE){
                dfs(i);
                if (!isPossible) return new int[0];
            }
        }
        return result;
    }

    private void dfs(int i) {
        if (color[i] == WHITE) {
            color[i] = GRAY;
            for (int node : map.getOrDefault(i, new ArrayList<>())) {
                dfs(node);
            }
            color[i] = BLACK;
            result[pointer] = i;
            pointer++;
        } else if(color[i] == GRAY) {
            isPossible = false;
        }
    }
}
