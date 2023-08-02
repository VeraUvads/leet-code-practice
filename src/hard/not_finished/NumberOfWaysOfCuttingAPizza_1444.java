package hard.not_finished;

public class NumberOfWaysOfCuttingAPizza_1444 {
     int MOD = 1000000007;
    // HashMap<Integer, LinkedList<Integer>> columns;
    // HashMap<Integer, LinkedList<Integer>> rows;
//    HashSet<Pair<Integer, Integer>> set = new HashSet<>();
    long ways = 0;
    int[][] apples;

    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        if (n == 0) return 0;
        int m = pizza[0].length();
        this.apples = new int[n][m];
        // this.rows = new HashMap<>();
        // this.columns = new HashMap<>();
        countApples(pizza);
        backTrack(0, n - 1, 0, m - 1);
        return (int) ways % MOD;
    }

    private void backTrack(int upRow, int downRow, int leftCol, int rightCol) { // how to avoid duplicates
        // while (rows[upRow] == 0 && upRow < downRow)  upRow++;
        // while (rows[downRow] == 0 && upRow < downRow) downRow--;
        // while (columns[leftCol] == 0 && leftCol < rightCol)  leftCol++;
        // while (columns[rightCol] == 0 && leftCol < rightCol) rightCol--;
//        if (rows[upRow] == 1) {  // how to update columns
//            ways++;
//            // rows[upRow]--;
//            // backTrack
//        }
//        backTrack()


    }

    private void countApples(String[] pizza) {
        for (int row = 0; row < pizza.length; row++) {
            for (int col = 0; col < pizza[row].length(); col++) {
                int symbol = pizza[row].charAt(col);
                if (symbol == 'A') {
                    // rows[row]++;
                    // columns[col]++;
                }
            }
        }
    }
}
