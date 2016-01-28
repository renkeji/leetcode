package solutions;

import junit.framework.TestCase;

public class Q330Test extends TestCase {

    public void testMinPatches() throws Exception {
        Q330 solution = new Q330();
        int[] nums = new int[]{1, 3};
        int actual = solution.minPatches(nums, 6);
        assertEquals(1, actual);

        nums = new int[]{1, 5, 10};
        actual = solution.minPatches(nums, 20);
        assertEquals(2, actual);

        nums = new int[]{1, 2, 2};
        actual = solution.minPatches(nums, 5);
        assertEquals(0, actual);

        nums = new int[]{1, 2, 31, 33};
        actual = solution.minPatches(nums, 2147483647);
        assertEquals(28, actual);
    }

}