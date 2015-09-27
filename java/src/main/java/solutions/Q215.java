package solutions;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * For example,
 *  Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 *  You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class Q215 extends Solution {

    // Quick select algorithm
    public int findKthLargest(int[] nums, int k) {
        assert nums != null && nums.length > 0 : "Input nums array is invalid!";
        assert k > 0 : "Value of k should be greater than 0";

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = (int)(Math.random() * (right - left + 1)) + left;
            int newPivotIndex = partition(nums, left, right, pivotIndex);
            if (newPivotIndex == k - 1) {
                return nums[newPivotIndex];
            } else if (newPivotIndex < k - 1) {
                left = newPivotIndex + 1;
            } else {
                right = newPivotIndex - 1;
            }
        }
        return 0;   // should NOT reach here
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        int newPivotIndex = left;
        swap(nums, pivotIndex, right);
        for (int i = left; i < right; ++i) {
            if (nums[i] > pivot) {
                swap(nums, i, newPivotIndex++);
            }
        }
        swap(nums, newPivotIndex, right);
        return newPivotIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
