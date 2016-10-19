package solutions;

public class Q367 extends Solution {

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num / 2 + 1;
        while (left <= right) {
            long  mid = left + (right - left) / 2;
            long  mul = mid * mid;
            if (mul == num) return true;
            else if (mul > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

}
