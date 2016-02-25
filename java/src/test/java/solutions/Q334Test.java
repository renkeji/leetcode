package solutions;

import junit.framework.TestCase;

public class Q334Test extends TestCase {

    public void testIncreasingTriplet() throws Exception {
        Q334 solution = new Q334();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        assertTrue(solution.increasingTriplet(nums));

        nums = new int[]{5, 4, 3, 2, 1};
        assertFalse(solution.increasingTriplet(nums));

        nums = new int[]{2147483646,2147483647,2147483647};
        assertFalse(solution.increasingTriplet(nums));

        nums = new int[] {0, 10, -1, -1, 100};
        assertTrue(solution.increasingTriplet(nums));

        nums = new int[] {1, 2, -10, -8, -7};
        assertTrue(solution.increasingTriplet(nums));

        nums = new int[] {5, 10, -1, 11};
        assertTrue(solution.increasingTriplet(nums));

        nums = new int[] {5, 10, -1, -7, 2, 3};
        assertTrue(solution.increasingTriplet(nums));
    }

}