package solutions;

import junit.framework.TestCase;

public class Q169Test extends TestCase {

    public void testMajorityElement() throws Exception {
        Q169 solution = new Q169();
        int[] nums = {1,0,0,2};
        int expected = 0;
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }

}