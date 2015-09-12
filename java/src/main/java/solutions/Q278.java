package solutions;

public class Q278 extends Solution {

    // mock method
    private boolean isBadVersion(int n) {
        return n % 2 == 0;
    }

    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid-1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
