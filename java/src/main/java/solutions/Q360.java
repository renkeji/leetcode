package solutions;

/**
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 *
 * The returned array must be in sorted order.
 *
 * Expected time complexity: O(n)
 *
 * Example:
 *  nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 *  Result: [3, 9, 15, 33]
 *
 *  nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 *  Result: [-23, -5, 1, 7]
 */

public class Q360 extends Solution {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        } else {
            int[] res = new int[nums.length];
            double sweetSpot = (-1.0 * b) / (2 * a);
            int index = searchInsert(nums, sweetSpot);
            int left = index - 1, right = index, i = a >= 0 ? 0 : nums.length - 1;
            while (left >= 0 && right < nums.length) {
                if (Math.abs(nums[left] - sweetSpot) <= Math.abs(nums[right] - sweetSpot)) {
                    res[i] = calculate(nums[left--], a, b, c);
                } else {
                    res[i] = calculate(nums[right++], a, b, c);
                }
                i = a >= 0 ? i + 1 : i - 1;
            }
            while (left >= 0) {
                res[i] = calculate(nums[left--], a, b, c);
                i = a >= 0 ? i + 1 : i - 1;
            }
            while (right < nums.length) {
                res[i] = calculate(nums[right++], a, b, c);
                i = a >= 0 ? i + 1 : i - 1;
            }
            return res;
        }
    }

    private int searchInsert(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
