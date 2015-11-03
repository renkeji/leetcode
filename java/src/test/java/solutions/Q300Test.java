package solutions;

import junit.framework.TestCase;

public class Q300Test extends TestCase {

    public void testLengthOfLIS() throws Exception {
        Q300 solution = new Q300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        int actual = solution.lengthOfLIS(nums);
        assertEquals(expected, actual);
    }

}