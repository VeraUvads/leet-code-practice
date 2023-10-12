package hard;

public class MinimumDistanceToTypeAWordUsingTwoFingers_1320 {
    // https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/description/
    int cols = 6;
    String word;
    Integer[][][] memo;

    public int minimumDistance(String word) {
        this.word = word;
        this.memo = new Integer[27][27][word.length()];
        return dfs(null, null, 0);
    }

    private int dfs(Character firstFinger, Character secondFinger, int index) {
        if (index == word.length()) {
            return 0;
        }
        int firstFingerKey = firstFinger == null ? 26 : (firstFinger - 'A');
        int secondFingerKey = secondFinger == null ? 26 : (secondFinger - 'A');

        char next = word.charAt(index);

        if (memo[firstFingerKey][secondFingerKey][index] != null) {
            return memo[firstFingerKey][secondFingerKey][index];
        }

        int distance1 = getDistance(firstFinger, next);
        int fromFirst = dfs(next, secondFinger, index + 1) + distance1;

        int distance2 = getDistance(secondFinger, next);
        int fromSecond = dfs(firstFinger, next, index + 1) + distance2;

        int result = Math.min(fromFirst, fromSecond);
        memo[firstFingerKey][secondFingerKey][index] = result;
        return result;
    }

    private int getDistance(Character symbol1, Character symbol2) {
        if (symbol1 == null || symbol2 == null) return 0;

        int x1 = (symbol1 - 'A') / cols;
        int y1 = (symbol1 - 'A') % cols;

        int x2 = (symbol2 - 'A') / cols;
        int y2 = (symbol2 - 'A') % cols;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
