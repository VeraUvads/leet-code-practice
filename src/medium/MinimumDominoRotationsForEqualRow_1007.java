package medium;

public class MinimumDominoRotationsForEqualRow_1007 {
    // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length == 0) return 0;
        int topAsRoot = countRotations(tops, bottoms, tops[0]);
        int bottomAsRoot = countRotations(tops, bottoms, bottoms[0]);
        if (topAsRoot == -1) {
            return bottomAsRoot;
        } else {
            return topAsRoot;
        }
    }

    private int countRotations(int[] tops, int[] bottoms, int root) {
        int rotationTop = 0, rotationBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != root && bottoms[i] != root) {
                return -1;
            } else if (tops[i] != root) {
                rotationTop++;
            } else if (bottoms[i] != root) {
                rotationBottom++;
            }
        }
        return Math.min(rotationTop, rotationBottom);
    }
}
