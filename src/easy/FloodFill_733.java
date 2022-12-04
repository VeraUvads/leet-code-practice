package easy;

import java.util.Stack;

public class FloodFill_733 {
    // https://leetcode.com/problems/flood-fill/?envType=study-plan&id=level-1

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length == 0) return image;
        int original = image[sr][sc];
        if (original == color) return image;
        Stack<Integer> stack = new Stack<>();
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        stack.add(sr);
        stack.add(sc);
        while (!stack.isEmpty()) {
            sc = stack.pop();
            sr = stack.pop();
            image[sr][sc] = color;
            for (int[] dirrection : dirs) {
                int newSr = sr + dirrection[0];
                int newSc = sc + dirrection[1];
                if (isOriginalColor(newSr, newSc, image, original)) {
                    stack.add(newSr);
                    stack.add(newSc);
                }
            }
        }
        return image;
    }

    public static boolean isOriginalColor(int sr, int sc, int[][] image, int original) {
        boolean isInBorder = sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
        return isInBorder && image[sr][sc] == original;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(array, 1, 1, 2);
        for (int[] first : array) {
            for (int second : first) {
                System.out.print(second + " ");
            }
            System.out.println();
        }
    }
}
