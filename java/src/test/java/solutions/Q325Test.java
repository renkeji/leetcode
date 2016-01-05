package solutions;

import junit.framework.TestCase;

public class Q325Test extends TestCase {

    public void testMaxSubArrayLen() throws Exception {
        Q325 solution = new Q325();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int expected = 4;
        int actual = solution.maxSubArrayLen(nums, 3);
        assertEquals(expected, actual);

        nums = new int[]{-2, -1, 2, 1};
        expected = 2;
        actual = solution.maxSubArrayLen(nums, 1);
        assertEquals(expected, actual);
    }

}