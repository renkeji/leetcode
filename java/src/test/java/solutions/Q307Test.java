package solutions;

import junit.framework.TestCase;
import solutions.Q307.NumArray;

public class Q307Test extends TestCase {

    public void testNumArray() throws Exception {
        int[] nums = {1, 3, 5};
        NumArray numArray = new Q307().new NumArray(nums);
        assertEquals(9, numArray.sumRange(0, 2));
        numArray.update(1, 2);
        assertEquals(8, numArray.sumRange(0, 2));
        assertEquals(8, numArray.sumRange(0, 2));
    }

}
