package solutions;

import junit.framework.TestCase;

public class Q215Test extends TestCase {

    public void testFindKthLargest() throws Exception {
        Q215 solution = new Q215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        int actual = solution.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

}