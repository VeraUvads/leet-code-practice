package medium;

import java.util.Stack;

public class AsteroidCollision_735 {
    // https://leetcode.com/problems/asteroid-collision/description/

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean isExplode = false;
            while (!stack.isEmpty() && asteroid < 0) {
                if (stack.peek() < 0)  break;

                int prev = stack.pop();
                isExplode = -prev == asteroid;
                if (isExplode) break;
                if (asteroid + prev > 0) {
                    asteroid = prev;
                }
            }
            if (!isExplode) stack.add(asteroid);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
