package medium;

import java.util.Arrays;
import java.util.HashSet;

public class TheLatestTimeToCatchABus_2332 {
    // https://leetcode.com/problems/the-latest-time-to-catch-a-bus/description/

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(passengers);
        Arrays.sort(buses);
        HashSet<Integer> set = new HashSet<>();
        int lastPassenger = 0;
        int lastAvailableTime = 1;
        for (int i = 0; i < buses.length; i++) {
            int busTime = buses[i];
            int currCapacity = 0;
            for (int j = lastPassenger; j < passengers.length; j++) {
                int passengerTime = passengers[j];
                if (passengerTime > busTime) break;
                set.add(passengerTime);
                lastPassenger = j + 1;
                if (!set.contains(passengerTime - 1)) {
                    lastAvailableTime = passengerTime - 1;
                }
                currCapacity++;
                if (currCapacity == capacity) break;
            }
            if (currCapacity < capacity && !set.contains(busTime)) {
                lastAvailableTime = busTime;
            }
        }
        return lastAvailableTime;
    }
}
