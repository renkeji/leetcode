package solutions;

import junit.framework.TestCase;

public class Q209Test extends TestCase {

    public void testMinSubArrayLen() throws Exception {
        Q209 solution = new Q209();
        int s = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int expected = 2;
        int actual = solution.minSubArrayLen(s, nums);
        assertEquals(expected, actual);

        s = 20;
        nums = new int[]{0, 1, 2, 3, 4, 5};
        expected = 0;
        actual = solution.minSubArrayLen(s, nums);
        assertEquals(expected, actual);

        s = 8;
        nums = new int[]{2, 3, 4, 5, 10};
        expected = 1;
        actual = solution.minSubArrayLen(s, nums);
        assertEquals(expected, actual);
    }

}