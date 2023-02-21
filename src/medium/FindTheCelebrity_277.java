package medium;

public class FindTheCelebrity_277 {
    // https://leetcode.com/problems/find-the-celebrity/submissions/902498780/
    public int findCelebrity(int n) {
        int[] outDegrees = new int[n];
        int celebrityCandidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate, n)) {
            return celebrityCandidate;
        } else {
            return -1;
        }
    }

    private boolean isCelebrity(int candidate, int n) {
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) {
                return false;
            }
        }
        return true;
    }

    public int findCelebrityBruteForce(int n) {
        int[] outDegrees = new int[n];
        int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (knows(i, j)) {
                    outDegrees[i]++;
                    inDegrees[j]++;
                }
                if (knows(j, i)) {
                    outDegrees[j]++;
                    inDegrees[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (outDegrees[i] == 0 && inDegrees[i] == n - 1) return i;
        }
        return -1;
    }

    // Default in leetcode
    private boolean knows(int a, int b) {
        return true;
    }

}
