package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q238Test extends TestCase {

    public void testProductExceptSelf() throws Exception {
        Q238 solution = new Q238();
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] actual = solution.productExceptSelf(nums);
        assertArrayEquals(expected, actual);
    }

}