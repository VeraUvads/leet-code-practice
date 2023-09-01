package medium;

public class MaximizeDistanceToClosestPerson_849 {
    // https://leetcode.com/problems/maximize-distance-to-closest-person/description/

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int max = 0;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (i - counter == 0 && seats[0] == 0) {
                    max = Math.max(max, counter );
                } else {
                    max = Math.max(max, (counter + 1) / 2);
                }
                counter = 0;
            } else {
                counter++;
            }
        }
        if (seats[n - 1] == 0) {
            max = Math.max(max, counter);
        } else {
            max = Math.max(max, (counter + 1) / 2);
        }
        return max;
    }
}
