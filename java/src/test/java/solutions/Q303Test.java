package solutions;

import junit.framework.TestCase;

import solutions.Q303.NumArray;

public class Q303Test extends TestCase {

    public void testNumArray() throws Exception {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new Q303().new NumArray(nums);
        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }

}