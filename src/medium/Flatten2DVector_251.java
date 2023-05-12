package medium;

public class Flatten2DVector_251 {
    // https://leetcode.com/problems/flatten-2d-vector/description/
    private final int[][] vector;
    private final int[] position;

    public Flatten2DVector_251(int[][] vec) {
        this.vector = vec;
        this.position = new int[]{0,0};
    }

    public int next() {
        if (!hasNext()) throw new RuntimeException("");
        int row = position[0];
        int col = position[1];
        int result = vector[row][col];
        movePointer();
        return result;
    }

    private void movePointer() {
        int row = position[0];
        int col = position[1];
        position[1] = (col + 1) % vector[row].length;
        if (position[1] == 0) position[0]++;
    }

    public boolean hasNext() {
        while (position[0] < vector.length) {
            if (vector[position[0]].length != 0) return true;
            position[0]++;
        }
        return false;
    }
}
