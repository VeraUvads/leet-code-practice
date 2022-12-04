package easy;

public class FirstBadVersion_278 {

    // https://leetcode.com/problems/first-bad-version/description/?envType=study-plan&id=level-1

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int result = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    // stub
    public boolean isBadVersion(int version) {
        return true;
    }
}
