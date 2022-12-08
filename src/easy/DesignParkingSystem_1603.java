package easy;

public class DesignParkingSystem_1603 {
    // https://leetcode.com/problems/design-parking-system/description/
    private final int[] slots;

    public DesignParkingSystem_1603(int big, int medium, int small) {
        slots = new int[]{ big, medium, small };
    }

    public boolean addCar(int carType) {
        return --slots[carType - 1] >= 0;
    }
}
