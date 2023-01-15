package medium;

public class BattleshipsInABoard_419 {
    // https://leetcode.com/problems/battleships-in-a-board/description/

    public int countBattleships(char[][] board) {
        int answer = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == '.') continue;
                if (row > 0 && board[row - 1][column] == 'X') continue;
                if (column > 0 && board[row][column - 1] == 'X') continue;
                answer++;
            }
        }
        return answer;
    }
}
