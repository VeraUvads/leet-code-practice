package hard;

import kotlin.Pair;
import utils.Robot;

import java.util.HashSet;

public class RobotRoomCleaner_489 {
    // https://leetcode.com/problems/robot-room-cleaner/description/
    Robot robot;
    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        visited.add(new Pair<>(0, 0));

        backtrack(0, 0, 0);

    }
    /*
    up

    [2,2,1],
    [2(2)1],
    [2,0,1],

    */

    private void backtrack(int row, int col, int d) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            Pair<Integer, Integer> pair = new Pair<>(row + dirs[newD][0], col + dirs[newD][1]);
            if (visited.add(pair) && robot.move()) {
                backtrack(pair.getFirst(), pair.getSecond(), newD);
                goBack();
            }
            robot.turnLeft(); // -> init: left, turn: down, turn: right, turn : up, turn: left
        }
    }

    private void goBack() {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
