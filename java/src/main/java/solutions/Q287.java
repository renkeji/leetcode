package solutions;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 *  1. You must not modify the array (assume the array is read only).
 *  2. You must use only constant, O(1) extra space.
 *  3. Your runtime complexity should be less than O(n^2).
 *  4. There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class Q287 extends Solution {

    public int findDuplicate(int[] nums) {
        assert nums != null;
        assert nums.length > 1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
